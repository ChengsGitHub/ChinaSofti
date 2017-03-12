/*
 * Copyright (c) 2003 The Visigoth Software Society. All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Visigoth Software Society (http://www.visigoths.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. Neither the name "FreeMarker", "Visigoth", nor any of the names of the
 *    project contributors may be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact visigoths@visigoths.org.
 *
 * 5. Products derived from this software may not be called "FreeMarker" or "Visigoth"
 *    nor may "FreeMarker" or "Visigoth" appear in their names
 *    without prior written permission of the Visigoth Software Society.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE VISIGOTH SOFTWARE SOCIETY OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Visigoth Software Society. For more
 * information on the Visigoth Software Society, please see
 * http://www.visigoths.org/
 */

package freemarker.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import freemarker.template.SimpleDate;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDateModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 * A holder for builtins that operate exclusively on TemplateSequenceModels.
 */

abstract class NumericalBuiltins {
    abstract static class NumberBuiltIn extends BuiltIn {
        TemplateModel _getAsTemplateModel(Environment env)
                throws TemplateException
        {
            TemplateModel model = target.getAsTemplateModel(env);
            return calculateResult(EvaluationUtil.getNumber(model, target, env), model);
        }
        
        abstract TemplateModel calculateResult(Number num, TemplateModel model)
        throws TemplateModelException;
    }

    static class byteBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            if (num instanceof Byte) {
                return model;
            }
            return new SimpleNumber(new Byte(num.byteValue()));
        }
    }

    static class shortBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            if (num instanceof Short) {
                return model;
            }
            return new SimpleNumber(new Short(num.shortValue()));
        }
    }

    static class intBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            if (num instanceof Integer) {
                return model;
            }
            return new SimpleNumber(num.intValue());
        }
    }

    // Does both someNumber?long and someDate?long, thus it doesn't extend NumberBuiltIn
    static class longBI extends BuiltIn {
        TemplateModel _getAsTemplateModel(Environment env)
                throws TemplateException
        {
            TemplateModel model = target.getAsTemplateModel(env);
            if (!(model instanceof TemplateNumberModel)
                    && model instanceof TemplateDateModel) {
                Date date = EvaluationUtil.getDate((TemplateDateModel) model, target, env);
                return new SimpleNumber(date.getTime());
            } else {
                Number num = EvaluationUtil.getNumber(model, target, env);
                if (num instanceof Long) {
                    return model;
                }
                return new SimpleNumber(num.longValue());
            }
        }
    }

    static class floatBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            if (num instanceof Float) {
                return model;
            }
            return new SimpleNumber(num.floatValue());
        }
    }

    static class doubleBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            if (num instanceof Double) {
                return model;
            }
            return new SimpleNumber(num.doubleValue());
        }
    }


    private static final BigDecimal BIG_DECIMAL_ONE = new BigDecimal("1");

    static class floorBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            return new SimpleNumber(new BigDecimal(num.doubleValue()).divide(BIG_DECIMAL_ONE, 0, BigDecimal.ROUND_FLOOR));
        }
    }

    static class ceilingBI extends NumberBuiltIn {
        TemplateModel calculateResult(Number num, TemplateModel model) {
            return new SimpleNumber(new BigDecimal(num.doubleValue()).divide(BIG_DECIMAL_ONE, 0, BigDecimal.ROUND_CEILING));
        }
    }

    static class roundBI extends NumberBuiltIn {
        private static final BigDecimal half = new BigDecimal("0.5");
        TemplateModel calculateResult(Number num, TemplateModel model) {
            return new SimpleNumber(new BigDecimal(num.doubleValue()).add(half).divide(BIG_DECIMAL_ONE, 0, BigDecimal.ROUND_FLOOR));
        }
    }

 
    // Doesn't extend NumberBuiltIn because "calculateResult" would need the Environment.
    static class cBI extends BuiltIn {
        TemplateModel _getAsTemplateModel(Environment env)
                throws TemplateException
        {
            TemplateModel model = target.getAsTemplateModel(env);
            Number num = EvaluationUtil.getNumber(model, target, env);
            if (num instanceof Integer) {
                // We accelerate this fairly common case
                return new SimpleScalar(num.toString());
            } else {
                return new SimpleScalar(env.getCNumberFormat().format(num));
            }
        }
    }
    
    private static final BigDecimal BIG_DECIMAL_LONG_MIN = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final BigDecimal BIG_DECIMAL_LONG_MAX = BigDecimal.valueOf(Long.MAX_VALUE); 
    private static final BigInteger BIG_INTEGER_LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger BIG_INTEGER_LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE); 
    
    private static final long safeToLong(Number num) throws TemplateModelException {
        if (num instanceof Double) {
            double d = Math.round(((Double) num).doubleValue());
            if (d > Long.MAX_VALUE || d < Long.MIN_VALUE) {
                throw new TemplateModelException(
                        "Number doesn't fit into a 64 bit signed integer (long): "
                        + d);
            } else {
                return (long) d;
            }
        } else if (num instanceof Float) {
            float f = Math.round(((Float) num).floatValue());
            if (f > Long.MAX_VALUE || f < Long.MIN_VALUE) {
                throw new TemplateModelException(
                        "Number doesn't fit into a 64 bit signed integer (long): "
                        + f);
            } else {
                return (long) f;
            }
        } else if (num instanceof BigDecimal) {
            BigDecimal bd = ((BigDecimal) num).setScale(0, BigDecimal.ROUND_HALF_UP);
            if (bd.compareTo(BIG_DECIMAL_LONG_MAX) > 0 || bd.compareTo(BIG_DECIMAL_LONG_MIN) < 0) {
                throw new TemplateModelException(
                        "Number doesn't fit into a 64 bit signed integer (long): "
                        + bd);
            } else {
                return bd.longValue();
            }
        } else if (num instanceof BigInteger) {
            BigInteger bi = (BigInteger) num;
            if (bi.compareTo(BIG_INTEGER_LONG_MAX) > 0 || bi.compareTo(BIG_INTEGER_LONG_MIN) < 0) {
                throw new TemplateModelException(
                        "Number doesn't fit into a 64 bit signed integer (long): "
                        + bi);
            } else {
                return bi.longValue();
            }
        } else if (num instanceof Long || num instanceof Integer
                || num instanceof Byte || num instanceof Short) {
            // Should add Atomic* types in 2.4...
            return num.longValue();
        } else {
            throw new TemplateModelException(
                    "Unsupported number type: " + num.getClass());
        }
    }
    
    static class number_to_dateBI extends NumberBuiltIn {
        
        private final int dateType;
        
        number_to_dateBI(int dateType) {
            this.dateType = dateType;
        }
        
        TemplateModel calculateResult(Number num, TemplateModel model)
        throws TemplateModelException {
            return new SimpleDate(new Date(safeToLong(num)), dateType);
        }
    }
    
}

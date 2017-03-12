/*
数字型
      number：存储整数和浮点数，最大38位精度
      number(n)：仅能存储整数，n代表最大位数  number(4) -9999~9999
      number(p,s)：存储浮点数，p代表最大精度，s代表最多小数位数  number(5,2)
字符型
      varchar2(n)：变长字符串，n代表存储的最大字节数，最大4000字节  varchar2(6) 中国
      char(n)：定长字符串，同上，最大2000字节 char(6) 中国  
      clob：大字符串，最大4G，效率低
日期型
      date：存储年月日时分秒
      timestamp：精确到纳秒
二进制类型
      blob：大二进制，最大4G
*/

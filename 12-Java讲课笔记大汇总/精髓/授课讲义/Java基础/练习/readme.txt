Account:
1.balance������Ϊprotected

SavingsAccount:
1.SavingsAccount�������չAccount��
2.����������һ������Ϊdouble��interestRate����
3.������������������������balance��interest_rate���Ĺ��й��������ù���������ͨ������super(balance)��balance�������ݸ����๹����

CheckingAccount:
1.CheckingAccount�������չAccount��
2.����������һ������Ϊdouble��overdraftProtection����
3.��������������һ������(balance)�Ĺ��й��������ù���������ͨ������super(balance)��balance�������ݸ����๹����
4.������������һ��������������(balance��protect)�Ĺ��й��������ù���������ͨ������super(balance)������overdraftProtection���ԣ���balance�������ݸ����๹����
5.CheckingAccount����븲��withdraw�������˷�������ִ�����м�飺�����ǰ����㹻�ֲ�ȡ��amount�����������У��������͸֧������������overdraftProtection���ֲ��ò�ֵ������ֲ���͸֧����Ҫ�Ľ����ڵ�ǰ�ı�����������������ʧ�ܣ������δ��Ӱ�졣
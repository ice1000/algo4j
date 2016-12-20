/*
大整数除法（整数范围）。
利用竖式除法手算规则的特点进行计算，
1.截取与除数长度相同的数tem进行第一次运算。
2.利用循环将tem与除数的倍数进行比较，比较中最后一个小于或等于tem的倍数i，便是当前的商。
3.将tem减去除数与商的倍数取余。并存入tem。
4.回到2重复运算，直到被除数被取完为止。

cult函数为除法运算函数。
*/

#include <cstdio>
#include <cstring>
#include <iostream>
using namespace std;

void fpluss(char a[150], char b[150], char c[150])
{
	//大整数减法运算函数，char a[150]接受被除数；char b[150]接收除数。c[150]用于返还差值的字符串序列。
	int aa[150], bb[150],
			cc[150];
	//用于将数组a,b中的值分割成整数块，便于运算。cc[150]用于暂存cc的运算结果。
	int l1 = strlen(a), l2 = strlen(b);
	int len, ccc, i;
	int t;
	//********************************** 将数组a和b分别翻转。
	for (i = 0; i < l1 / 2; i++)
	{
		char temp;
		temp = a[i];
		a[i] = a[l1 - 1 - i];
		a[l1 - 1 - i] = temp;
	}
	for (i = 0; i < l2 / 2; i++)
	{
		char temp;
		temp = b[i];
		b[i] = b[l2 - 1 - i];
		b[l2 - 1 - i] = temp;
	}
	//**********************************

	len = l1 > l2 ? l1 : l2;
	//取最长字符的长度为基本运算步数。

	//*********************************************
	//将字符串字符向整数块转换，并将aa，bb长度补齐。
	ccc = 1;
	for (i = 0; i <= len; i++)
	{
		if (a[i] =='')
			ccc = 0;
		if (ccc == 1)
			aa[i] = a[i] - '0';
		else
			aa[i] = 0;
	}
	ccc = 1;
	for (i = 0; i <= len; i++)
	{
		if (b[i] =='')
			ccc = 0;
		if (ccc == 1)
			bb[i] = b[i] - '0';
		else
			bb[i] = 0;
	}
}

//*********************************************
//运算主体。

for (i = 0; i < len; i++)
{
	if (aa[i] < bb[i])
	{
		//判定，如果需要进位则从下一个数夺取1。
		aa[i] += 10;
		aa[i + 1]--;
	}
	t = (aa[i] - bb[i]);
	//利用t存储每一步的结果。
	cc[i] = t;
}
cc[i] = aa[i];
//取得最后一位。

//*********************************************

ccc = 1;
int j = 0;
for (i = len; i >= 0; i--)
{
	//将整数数组块整合为字符串传回。
	if (cc[i] != 0)
		ccc = 0;
	if (ccc == 0)
	{
		c[j++] = cc[i] + '0';
	}
}
if (j == 0)
	c[j++] = '0';
c[j] ='';
}

void mult(char a[150], int b, char c[150])
{
	//大数乘法运算函数.char a[150]用于接收第一个乘数，由于本程序运算规则，第二个乘数为0~10的整数，因此用整型传递。c用以传递结果。
	int tt, i, t;
	int len = strlen(a);
	tt = 0;
	//*********************************************
	//翻转a。
	for (i = 0; i < len / 2; i++)
	{
		char temp;
		temp = a[i];
		a[i] = a[len - 1 - i];
		a[len - 1 - i] = temp;
	}

	//*********************************************
	//运算主体。以t为暂存点。
	for (i = 0; i < len; i++)
	{
		t = (a[i] - '0') * b;
		t += tt;
		c[i] = t + '0';
		tt = t / 10;
	}
	c[i++] = tt + '0';
	c[i] ='';
	//*********************************************
	//消零。
	for (i = strlen(c) - 1; i >= 0; i--)
	{
		if (c[i] != '0')
			break;
		c[i] ='';
	}

	//*********************************************
	//对结果c进行翻转。
	len = strlen(c);
	char tsp;
	for (i = 0; i < len / 2; i++)
	{
		tsp = c[i];
		c[i] = c[len - 1 - i];
		c[len - 1 - i] = tsp;
	}

	//*********************************************
	//再次翻转a使其恢复原状，继续供除法函数cult使用。
	len = strlen(a);
	for (i = 0; i < len / 2; i++)
	{
		char temp;
		temp = a[i];
		a[i] = a[len - 1 - i];
		a[len - 1 - i] = temp;
	}
}

int cmps(char *a, char *b)
{
	//比较函数，用于比较两个大数的大小。若a>b则返还1，若a=b则返还0，若a<b则返还-1。该函数用以替换strcmp()的不足。
	int len1;
	int len2;
	int i;
	int ds = 0, dy = 0, ls = 0;
	while (*a == '0')
		*a++;
	while (*b == '0')
		*b++;

	len1 = strlen(a);
	len2 = strlen(b);
	if (len1 > len2)
		return 1;
	else if (len2 > len1)
		return -1;
	else
	{
		for (i = 0; i < len1; i++)
		{
			if (*(a + i) == *(b + i))
				dy++;
			if (*(a + i) > *(b + i))
				ds++;
			if (*(a + i) < *(b + i))
				ls++;
			if (*(a + i) > *(b + i) && ls == 0)
				return 1;
			if (*(a + i) < *(b + i) && ds == 0)
				return -1;
		}
	}
	return 0;
	//！当到达该处时只有一种情况存在，即a==b，因此无需给出返还的条件。
}

void cult(char a[150], char b[150], char d[150])
{
	//**核心部分，大数除法函数**
	// a[150]：被除数，b[150]：除数，d[150]：商。
	int len1 = strlen(a);
	int len2 = strlen(b);
	char tem[150];
	//每一步除法的运算数暂存器，相当于单步除法的被除数。
	char lbj[150];
	char c[150];
	//函数内的商！
	int len, len3;
	int i, cx;
	int js;
	int ii;
	if (cmps(b, a) > 0)
	{
		//取整运算中，当除数b大于被除数a时，宣告结果为0；
		d[0] = '0';
		d[1] ='';
		return;
	}
	len = len1;
	//由于被除数为最大数，理应拥有最大长度，则以其标识最小步数。
	for (i = 0; i < len2; i++)
		//!!1.首先提取一段被除数b长度len2的数串。
		tem[i] = a[i];
	tem[i] ='';
	ii = i;
	//将提取的被除数位置信息转存到ii。
	cx = 0;
	//cx是商c的存储位置计数器。
	while (ii <= len)
	{
		//每一步运算会向被除数索取一个新书，直到取玩最后一个数之后，运算终止。
		if (cmps(b, tem) > 0)
		{
			//!!2.如果取到的数tem小于除数b，则再向a取一位数.
			len3 = strlen(tem);
			tem[len3] = a[ii++];
			tem[len3 + 1] ='';
			c[cx++] = '0';
		}
		else
		{
			//!!3.当tem>b,开始算商。
			for (i = 1; i <= 10; i++)
			{
				//算商的过程是通过与一个1~9可能商里面的数与除数b的乘积lbj进行比较，当找到第一个比tem大的lbj时，结束当前过程，并取得前一个i，作为单步商 !!4.
				//i<=10而不是i<10.当运算 99999/1时就会发现商需要运算到10才能退出。
				mult(b, i, lbj);
				if (cmps(lbj, tem) > 0)
				{
					//!!4.
					mult(b, --i, lbj);
					break;
				}
			}
			c[cx++] = i + '0';
			//将商存入c；
			fpluss(tem, lbj, tem);
			//将tem-lbj得到余数再存入tem。
			len3 = strlen(tem);
			//以下为继续提取数字，以便继续运算。！！不可忽略。!!2处虽然也有提取数字，但其相当于一个运算步骤，需要得到一个商，会违背运算规则。
			tem[len3] = a[ii++];
			tem[len3 + 1] ='';
		}
	}

	c[cx] ='';
	//设置c结束点。
	int z = 0, k = 0;
	for (int j = 0; j <= cx; j++)
	{
		//将数组c的前缀0消除同时转存给d.
		if (c[j] != '0')
			z = 1;
		if (z == 1)
			d[k++] = c[j];
	}
}

int main()
{
	char a[250], b[250], c[50000];
	int len;
	int n;
	scanf("%d", &n);
	while (n--)
	{
		scanf("%s%s", a, b);
		cult(a, b, c);
		cout << c << endl;
	}
}

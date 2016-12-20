#include <stdio.h>
#include <string.h>
#include <math.h>

#define MAX_SIZE (1024)

char answer[MAX_SIZE];
char answersign;

void bigadd(char *n1, char *n2);
void bigsub(char *n1, char *n2);
void bigmul(char *n1, char *n2);
void bigtrim(char *num, int length);
void bigsort(char *n1, char *n2, int maxlen);
void printnum(char *num);

int main(int argc, char *argv[])
{
  int count, index, place;
  int len, len1, len2, maxlen;
  int i;
  char input[MAX_SIZE * 2], num[2][MAX_SIZE];
  void (*func)(char *, char *);

  scanf("%d", &count);

  while (count--)
  {
    scanf("%s", &input);
    len = strlen(input);
    index = 0;
    place = 0;
    for (i = len - 1; i >= 0; i--)
    {
      if (input[i] == '+' || input[i] == '-' || input[i] == '*')
      {
	if (input[i] == '+')
	{
	  func = bigadd;
	}
	else if (input[i] == '-')
	{
	  func = bigsub;
	}
	else if (input[i] == '*')
	{
	  func = bigmul;
	}
	num[0][place] = '\0';
	index = 1;
	place = 0;
      }
      else
      {
	num[index][place++] = input[i];
      }
    }
    num[1][place] = '\0';

    len1 = strlen(&num[0]);
    len2 = strlen(&num[1]);
    maxlen = (len1 > len2) ? len1 : len2;
    bigtrim(&num[0], maxlen);
    bigtrim(&num[1], maxlen);

    if (func == bigsub)
    {
      bigsort(&num[0], &num[1], maxlen);
    }

    func(&num[0], &num[1]);
    printnum(answer);
    printf("\n");
  }

  return 0;
}

void bigadd(char *n1, char *n2)
{
  int bit1, bit2, bit3, carry = 0;
  int i;

  answersign = '+';

  for (i = 0; i < MAX_SIZE; i++)
  {
    if (n1[i] >= '0' && n1[i] <= '9')
    {
      bit1 = n1[i] - '0';
    }
    else
    {
      bit1 = 0;
    }
    if (n2[i] >= '0' && n2[i] <= '9')
    {
      bit2 = n2[i] - '0';
    }
    else
    {
      bit2 = 0;
    }
    bit3 = (bit1 + bit2 + carry) % 10;
    carry = (bit1 + bit2 + carry >= 10) ? 1 : 0;
    answer[i] = '0' + bit3;
    if (n1[i] == '\0' && n2[i] == '\0')
    {
      i++;
      break;
    }
  }
  answer[i] = '\0';
  return;
}

void bigsub(char *n1, char *n2)
{
  int bit1, bit2, bit3, borrow = 0;
  int i;

  for (i = 0; i < MAX_SIZE; i++)
  {
    if (n1[i] >= '0' && n1[i] <= '9')
    {
      bit1 = n1[i] - '0';
    }
    else
    {
      bit1 = 0;
    }
    if (n2[i] >= '0' && n2[i] <= '9')
    {
      bit2 = n2[i] - '0';
    }
    else
    {
      bit2 = 0;
    }
    bit3 = (bit2 - bit1 - borrow + 10) % 10;
    borrow = (bit2 - bit1 - borrow < 0) ? 1 : 0;
    answer[i] = '0' + bit3;
    if (n1[i] == '\0' && n2[i] == '\0')
    {
      i++;
      break;
    }
  }
  answer[i] = '\0';
  return;
}

void bigmul(char *n1, char *n2)
{
  int bit1, bit2, bit3, carry;
  int len1, len2, maxlen;
  int i, j, k;
  char space[2][MAX_SIZE];

  answersign = '+';

  answer[0] = '0';
  answer[1] = '\0';

  for (i = 0; i < MAX_SIZE; i++)
  {
    if (n1[i] == '\0')
    {
      break;
    }
    carry = 0;
    for (j = 0; j < MAX_SIZE; j++)
    {
      if (n2[j] == '\0')
      {
	break;
      }
      bit1 = n1[i] - '0';
      bit2 = n2[j] - '0';
      bit3 = (bit1 * bit2 + carry) % 10;
      carry = (bit1 * bit2 + carry) / 10;
      space[1][i + j] = '0' + bit3;
    }
    for (k = 0; k < i; k++)
    {
      space[1][k] = '0';
    }
    space[1][i + j] = '0' + carry;
    space[1][i + j + 1] = '\0';
    strcpy(space[0], answer);

    len1 = strlen(&space[0]);
    len2 = strlen(&space[1]);
    maxlen = (len1 > len2) ? len1 : len2;
    bigtrim(&space[0], maxlen);
    bigtrim(&space[1], maxlen);
    bigadd(&space[0], &space[1]);
  }
  return;
}

void bigsort(char *n1, char *n2, int maxlen)
{ //make n1 <= n2.
  int i, j;
  char temp;

  answersign = '+';

  for (i = maxlen - 1; i >= 0; i--)
  {
    if (n1[i] == n2[i])
    {
      continue;
    }
    if (n1[i] > n2[i])
    {
      for (j = 0; j < maxlen; j++)
      {
	temp = n1[j];
	n1[j] = n2[j];
	n2[j] = temp;
      }
      answersign = '-';
    }
    break;
  }
  return;
}

void bigtrim(char *num, int length)
{
  int len;
  int i, j, k;

  len = strlen(num);

  for (i = 0; i < len; i++)
  {
    if (num[i] == '\0')
    {
      break;
    }
  }
  for (j = i - 1; j >= 0; j--)
  {
    if (num[j] == '0')
    {
      num[j] = '\0';
    }
    else
    {
      break;
    }
  }
  if (num[0] == '\0')
  {
    num[0] = '0';
  }
  if (length > 0)
  {
    for (k = i + 1; k <= length; k++)
    {
      num[k] = '\0';
    }
  }
  return;
}

void printnum(char *num)
{
  int len;
  int i;

  if (answersign == '-')
  {
    printf("-");
  }

  bigtrim(num, 0);
  len = strlen(num);
  for (i = len - 1; i >= 0; i--)
  {
    printf("%c", num[i]);
  }
  return;
}

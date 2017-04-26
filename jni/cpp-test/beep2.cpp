/*******************************************************************
 * Copyright (C) Jerry Jiang
 * File Name   : MultiThreadDlg.cpp
 * Author      : Jerry Jiang
 * Create Time : 2011-10-7 14:41:02
 * Mail        : jbiaojerry@gmail.com
 * Blog        : http://blog.csdn.net/jerryjbiao
 * Description : Beep函数播放《送别》、《传奇》和《生日快乐歌》
 ******************************************************************/

#include <iostream>
#include <windows.h>
using namespace std;

//定义低音
const int A1 = 131;
const int A2 = 147;
const int A3 = 165;
const int A4 = 175;
const int A5 = 196;
const int A6 = 220;
const int A7 = 247;

//定义中音
const int B1 = 262;
const int B2 = 296;
const int B3 = 330;
const int B4 = 349;
const int B5 = 392;
const int B6 = 440;
const int B7 = 494;

//定义高音
const int C1 = 523;
const int C2 = 587;
const int C3 = 659;
const int C4 = 698;
const int C5 = 784;
const int C6 = 880;
const int C7 = 988;

//定义高二度
const int D1 = 1047;
const int D2 = 1175;
const int D3 = 1319;
const int D4 = 1397;
const int D5 = 1568;
const int D6 = 1760;
const int D7 = 1976;

//定义节拍
const int OneBeat = 600;
const int HalfBeat = 300;

void HappyBirthday();
void Legend();
void SendOff();

int main() {
	cout << "**************************" << endl;
	cout << "*   1 - 送别             *" << endl;
	cout << "*   2 - 传奇             *" << endl;
	cout << "*   3 - 祝你生日快乐     *" << endl;
	cout << "*   0 - 退出             *" << endl;
	cout << "**************************" << endl;
	cout << "请选择歌曲：" << endl;

	int num = 0;
	while (true) {
		cin >> num;
		switch (num) {
			case 1:
				cout << "你选择了：1 - 送别" << endl;
				SendOff();
				break;
			case 2:
				cout << "你选择了：2 - 传奇" << endl;
				Legend();
				break;
			case 3:
				cout << "你选择了：3 - 祝你生日快乐" << endl;
				HappyBirthday();
				break;
			default:
				cout << "Thank you." << endl;
				return 0;
				break;
		}
	}

	return 0;
}

void HappyBirthday() {
	Beep(C5, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(C6, OneBeat);
	Beep(C5, OneBeat);
	Beep(D1, OneBeat);
	Beep(C7, OneBeat * 2);

	Beep(C5, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(C6, OneBeat);
	Beep(C5, OneBeat);
	Beep(D2, OneBeat);
	Beep(D1, OneBeat * 2);

	Beep(C5, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(D5, OneBeat);
	Beep(D3, OneBeat);
	Beep(D1, OneBeat);
	Beep(C7, OneBeat);

	Beep(D4, HalfBeat);
	Beep(D4, HalfBeat);
	Beep(D3, OneBeat);
	Beep(D1, OneBeat);
	Beep(D2, OneBeat);
	Beep(D1, OneBeat * 2);


	Beep(C5, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(D5, OneBeat);
	Beep(D3, OneBeat);
	Beep(D1, OneBeat);
	Beep(C7, HalfBeat);
	Beep(C6, OneBeat * 2);

	Beep(D4, HalfBeat);
	Beep(D4, HalfBeat);
	Beep(D3, OneBeat);
	Beep(D1, OneBeat);
	Beep(D2, OneBeat);
	Beep(D1, OneBeat * 3);

}

void Legend() {
	//只是因为在人群中多看了你一眼
	Beep(C1, HalfBeat);
	Beep(C1, OneBeat);
	Beep(C1, OneBeat);
	Beep(C3, OneBeat);
	Beep(C2, OneBeat);
	Beep(C2, HalfBeat);
	Beep(C2, HalfBeat / 2);
	Beep(C1, HalfBeat);
	Beep(C1, OneBeat);
	Beep(C1, HalfBeat);
	Beep(C2, OneBeat);
	Beep(C2, OneBeat);
	Beep(C1, HalfBeat);
	Beep(B6, HalfBeat);
	Beep(B6, HalfBeat / 2);
	Beep(B6, OneBeat * 2);

	//再也没能忘掉你容颜
	Beep(B7, HalfBeat);
	Beep(B7, HalfBeat);
	Beep(B7, OneBeat);
	Beep(C1, HalfBeat);
	Beep(C2, HalfBeat);
	Beep(C2, OneBeat);
	Beep(B7, OneBeat);
	Beep(B6, HalfBeat);
	Beep(B5, HalfBeat);
	Beep(B3, HalfBeat);
	Beep(B3, OneBeat * 2);

	//梦想着偶然能有一天再相见
	Beep(C3, HalfBeat);
	Beep(C2, HalfBeat);
	Beep(C3, OneBeat);
	Beep(C3, HalfBeat);
	Beep(C3, HalfBeat / 2);
	Beep(C2, HalfBeat);
	Beep(C2, OneBeat);
	Beep(C2, HalfBeat / 2);
	Beep(C1, HalfBeat);
	Beep(C1, OneBeat);
	Beep(C2, OneBeat);
	Beep(B6, OneBeat);
	Beep(B6, HalfBeat);
	Beep(B6, HalfBeat / 2);
	Beep(C2, HalfBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat * 2);

	//从此我开始孤单思念
	Beep(B7, HalfBeat);
	Beep(B7, HalfBeat);
	Beep(B7, OneBeat);
	Beep(C1, HalfBeat);
	Beep(C2, HalfBeat / 2);
	Beep(C2, OneBeat);
	Beep(C2, OneBeat);
	Beep(B6, HalfBeat);
	Beep(B5, OneBeat);
	Beep(B3, OneBeat * 2);

	//想你时你在天边
	Beep(C5, OneBeat);
	Beep(C2, HalfBeat / 2);
	Beep(C2, OneBeat);
	Beep(C3, OneBeat);
	Beep(C5, OneBeat);
	Beep(C2, HalfBeat);
	Beep(C2, OneBeat);
	Beep(D1, HalfBeat);
	Beep(B6, OneBeat * 2);

	Sleep(50);

	//想你时你在眼前
	Beep(C2, OneBeat);
	Beep(B6, HalfBeat / 2);
	Beep(B6, OneBeat);
	Beep(C3, OneBeat);
	Beep(C2, OneBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat);
	Beep(C1, OneBeat);
	Beep(B5, OneBeat * 2);

	//想你时你在脑海
	Beep(C5, OneBeat);
	Beep(C2, HalfBeat / 2);
	Beep(C2, OneBeat);
	Beep(C3, OneBeat);
	Beep(C5, OneBeat);
	Beep(C2, HalfBeat);
	Beep(C2, OneBeat);
	Beep(D1, OneBeat);
	Beep(B6, OneBeat * 2);

	Sleep(50);

	//想你时你在心田
	Beep(C2, OneBeat);
	Beep(B6, HalfBeat / 2);
	Beep(B6, OneBeat);
	Beep(C3, OneBeat);
	Beep(C2, OneBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat);
	Beep(C1, OneBeat);
	Beep(B5, OneBeat * 2);

	//宁愿相信我们前世有约
	Beep(C1, HalfBeat);
	Beep(C1, HalfBeat);
	Beep(C1, OneBeat);
	Beep(B5, HalfBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat);
	Beep(C5, OneBeat);
	Beep(D4, OneBeat);
	Beep(C3, OneBeat);
	Beep(C2, OneBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat * 2);

	//今生的爱情故事不会再改变
	Beep(C1, HalfBeat);
	Beep(C3, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(C6, OneBeat);
	Beep(C5, HalfBeat);
	Beep(C6, HalfBeat / 2);
	Beep(C6, HalfBeat);
	Beep(C5, OneBeat);
	Beep(C6, OneBeat);
	Beep(C5, HalfBeat);
	Beep(C3, HalfBeat);
	Beep(C3, HalfBeat);
	Beep(C2, OneBeat);
	Beep(C3, HalfBeat / 2);
	Beep(C3, OneBeat * 2);

	//宁愿用这一生等你发现
	Beep(C1, HalfBeat);
	Beep(C1, HalfBeat);
	Beep(C1, OneBeat);
	Beep(B5, HalfBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat);
	Beep(C5, OneBeat);
	Beep(D4, OneBeat);
	Beep(C3, OneBeat);
	Beep(C2, OneBeat);
	Beep(C1, HalfBeat / 2);
	Beep(C1, OneBeat * 2);

	//我一直在你身边从未走远
	Beep(C1, HalfBeat);
	Beep(C3, HalfBeat);
	Beep(C5, HalfBeat);
	Beep(C6, OneBeat);
	Beep(C5, HalfBeat);
	Beep(C6, HalfBeat / 2);
	Beep(C6, HalfBeat);
	Beep(C5, OneBeat);
	Beep(C6, OneBeat);
	Beep(C5, HalfBeat);
	Beep(C3, HalfBeat / 2);
	Beep(C5, OneBeat);
	Beep(C5, OneBeat * 4);
}

void SendOff() {
	//送别
	const int ONE_BEEP = 600;
	const int HALF_BEEP = 300;

	const int NOTE_1 = 440;
	const int NOTE_2 = 495;
	const int NOTE_3 = 550;
	const int NOTE_4 = 587;
	const int NOTE_5 = 660;
	const int NOTE_6 = 733;
	const int NOTE_7 = 825;

	//长亭外
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_5, HALF_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP * 2);

	//古道边
	Beep(NOTE_6, ONE_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP);
	Beep(NOTE_5, ONE_BEEP * 2);

	//芳草碧连天
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_1, HALF_BEEP);
	Beep(NOTE_2, HALF_BEEP);
	Beep(NOTE_3, ONE_BEEP);
	Beep(NOTE_2, HALF_BEEP);
	Beep(NOTE_1, HALF_BEEP);
	Beep(NOTE_2, ONE_BEEP * 4);

	//晚风扶柳笛声残
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_5, HALF_BEEP);
	Beep(NOTE_1 * 2, HALF_BEEP * 3);
	Beep(NOTE_7, HALF_BEEP);
	Beep(NOTE_6, ONE_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP);
	Beep(NOTE_5, ONE_BEEP * 2);

	//夕阳山外山
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_2, HALF_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_4, HALF_BEEP * 3);
	Beep((int)(NOTE_7 / 2 + 0.5), HALF_BEEP);
	Beep(NOTE_1, ONE_BEEP * 4);

	//天之涯
	Beep(NOTE_6, ONE_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP * 2);

	//地之角
	Beep(NOTE_7, ONE_BEEP);
	Beep(NOTE_6, HALF_BEEP);
	Beep(NOTE_7, HALF_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP * 2);

	//知交半零落
	Beep(NOTE_6, HALF_BEEP);
	Beep(NOTE_7, HALF_BEEP);
	Beep(NOTE_1 * 2, HALF_BEEP);
	Beep(NOTE_6, HALF_BEEP);
	Beep(NOTE_6, HALF_BEEP);
	Beep(NOTE_5, HALF_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_1, HALF_BEEP);
	Beep(NOTE_2, ONE_BEEP * 4);

	//一壶浊酒尽余欢
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_5, HALF_BEEP);
	Beep(NOTE_1 * 2, HALF_BEEP * 3);
	Beep(NOTE_7, HALF_BEEP);
	Beep(NOTE_6, ONE_BEEP);
	Beep(NOTE_1 * 2, ONE_BEEP);
	Beep(NOTE_5, ONE_BEEP * 2);

	//今宵别梦寒
	Beep(NOTE_5, ONE_BEEP);
	Beep(NOTE_2, HALF_BEEP);
	Beep(NOTE_3, HALF_BEEP);
	Beep(NOTE_4, HALF_BEEP * 3);
	Beep((int)(NOTE_7 / 2 + 0.5), HALF_BEEP);
	Beep(NOTE_1, ONE_BEEP * 3);

	Sleep(10000);
}

#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Matrix {
	vector<vector<int> > matrix;
	Matrix(int a, int b) {
		 vector<vector<int>> bf(a, vector<int>(b));
		 matrix = bf;
	}
	Matrix operator+(Matrix x) {
		for (size_t i = 0; i < x.matrix.size() - 1 ; i++)
		{
			for (size_t j = 0; j < x.matrix.size() - 1; j++)
			{

			}
		}
	}
};
class BigInt{
public:
	string number;
	BigInt() {
		number = "";
	}
	BigInt(char * c) {
		number = c;
	}
	BigInt(int x) {
		number = to_string(x);
	}
	BigInt(BigInt & obj) {

		number = obj.number;
	}
	int operator[](int n) {
		return number[n] - '0';
	}
	bool IsNeg(BigInt x) { return x.number[0] == '-'; }
	bool IsSameSign(BigInt x, BigInt y) { return IsNeg(x) == IsNeg(y); }
	bool operator>(BigInt obj) {
		bool buff = true;
		if (IsSameSign(*this, obj)) {
			if (IsNeg(obj)) buff = false;
		}
		else return IsNeg(obj);
		if (this->size() == obj.size()) return this->number > obj.number;
		if (this->size() > obj.size()) return buff;
		return !buff;
	}
	bool operator<(BigInt obj) {
		return !(*this > obj);
	}
	bool operator==(BigInt obj) {
		return this->number == obj.number;
	}
	bool operator!=(BigInt obj) {
		return !(*this == obj);
	}

	int size() {
		return number.size();
	}
	BigInt swapSign(BigInt x) {
		if (IsNeg(x)) x.number.erase(0, 1);
		else x.number = '-' + x.number;
		return x;
	}
	BigInt operator-(BigInt x) {
		BigInt y = *this;
		bool isNegSub = false;
		bool isSwap = false;
		if (!IsSameSign(y, x)) {
			x = swapSign(x);
			return y + x;
		}
		else if(IsNeg(x)) {
			isNegSub = true;
		}
		if (IsNeg(x)) x.number.erase(0, 1);
		if (IsNeg(y)) y.number.erase(0, 1);
		if (y < x) {
			swap(x.number, y.number);
			if (isNegSub) isNegSub = false;
			else isSwap = true;
		}
		for (int i = x.size() - 1; i >= 0; i--)
		{
			int j = y.size() - x.size() + i;
			y = Minus(y, x[i], j);
		}
		if (isNegSub || isSwap) {
			y = '-' + y.number;
		}
		return y;
	}
	BigInt Minus(BigInt numb, int obj, int j) {
		BigInt toRet = numb;
		int buff = numb[j] - obj;
		if (buff < 0) {
			toRet.number[j] = '0' + 10 + numb[j] - obj;
			if (j - 1 >= 0) toRet = Minus(toRet, 1, j - 1);
		}
		else {
			toRet.number[j] = '0' + buff;
			if ((toRet[0] == 0) && toRet.number.length() != 1) toRet.number.erase(0, 1);
		}
		return toRet;
	}
	BigInt& operator+=(BigInt obj) {
		*this = *this + obj;
		return *this;
	}
	BigInt operator*(BigInt x) {
		BigInt y = *this;
		for (BigInt i = 2; i < x; i++)
		{
			y += *this;
		}
		return y;
	}
	BigInt operator+(BigInt x) {
		BigInt y = *this;
		bool isNegSum = false;
		if (IsSameSign(y, x)) {
			if (IsNeg(x)) {
				isNegSum = true;
				y.number[0] = '0';
				x.number[0] = '0';
			}
		}
		if (y < x) swap(x.number, y.number);
		if (!IsSameSign(y, x)) return y - x;
		for (int i = x.size() - 1; i >= 0; i--)
		{
			int j = y.size() - x.size() + i;
			y = Plus(y, x[i], j);
		}
		if (isNegSum) {
			if (y[0] == 0) y.number[0] = '-';
			else y.number = '-' + y.number;
		}
		return y;
	}
	BigInt operator++ (int) {
		BigInt buff = *this;
		*this = *this + BigInt(1);
		return buff;
	}
	BigInt operator-- (int) {
		BigInt buff = *this;
		*this = *this - BigInt(1);
		return buff;
	}
	BigInt operator++() {
		*this = *this + BigInt(1);
		return *this;
	}
	BigInt operator--() {
		*this = *this - BigInt(1);
		return *this;
	}
	BigInt& operator=(BigInt obj) {
		this->number = obj.number;
		return *this;
	}
	BigInt& operator=(string obj) {
		this->number = obj;
		return *this;
	}
	friend ostream& operator<<(ostream& os, const BigInt& x) {
		os << x.number;
		return os;
	}
	BigInt Plus(BigInt numb, int obj, int j) {
		BigInt toRet = numb;
		int buff = numb[j] + obj;
		if(buff >= 10) {
			toRet.number[j] = '0' + buff % 10;
			if(j - 1 >= 0) toRet = Plus(toRet, 1, j - 1);
			else toRet = '1' + toRet.number;
		}
		else toRet.number[j] = '0' + buff;
		return toRet;
	}
};


int main()
{	
}


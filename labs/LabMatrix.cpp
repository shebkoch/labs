#include <vector>
#include <iostream>
using namespace std;
class Matrix {
public:
	vector<vector<int> > v;
	int n;
	int m;
	Matrix(int _n, int _m) {
		vector< vector<int> > vv(_n, vector<int>(_m));
		v = vv;
		n = _n;
		m = _m;
	}
	Matrix(Matrix & x) {
			v = x.v;
			n = x.n;
			m = x.m;
	}
	Matrix() {
		n = 0;
		m = 0;

	}
	bool isSameSize(Matrix x, Matrix y) {
		return (x.n == y.n) && (x.m == y.m);
	}
	vector<int> & operator[](int x) {
		return v[x];
	}
	Matrix operator+(Matrix x) {
		if (!isSameSize(*this, x)) throw "Size isn't same";
		for (size_t i = 0; i < n; i++)
		{
			for (size_t j = 0; j < m; j++)
			{
				(*this)[i][j] += x[i][j];
			}
		}
		return *this;
	}
	Matrix operator-(Matrix x) {
		return *this + x;
	}
	Matrix operator+(int x) {
		for (size_t i = 0; i < n; i++)
			for (size_t j = 0; j < m; j++)
				(*this)[i][j] += x;
		return *this;
	}
	Matrix operator-(int x) {
		return *this + x;
	}
	Matrix operator*(Matrix x) {
		if (this->n != x.m) throw "* is impossible";
		Matrix bf;
		for (size_t i = 0; i < n; i++)
		{
			for (size_t j = 0; j < m; j++)
			{
				bf[i][j] = 0;
				for (int k = 0; k < n; k++)
					bf[i][j] += (*this)[i][k] * x[k][j];
			}
		}
		return *this;
	}
	Matrix operator*(int x) {
		for (size_t i = 0; i < n; i++)
			for (size_t j = 0; j < m; j++)
				(*this)[i][j] *= x;
		return *this;
	}
	Matrix& operator=(Matrix x) {
		this->v = x.v;
		this->n = x.n;
		this->m = x.m;
		return *this;
	}
	Matrix& operator+=(Matrix x) {
		*this = *this + x;
		return *this;
	}
	Matrix& operator-=(Matrix x) {
		*this = *this - x;
		return *this;
	}
	Matrix& operator*=(Matrix x) {
		*this = *this * x;
		return *this;
	}
	Matrix& operator+=(int x) {
		*this = *this + x;
		return *this;
	}
	Matrix& operator-=(int x) {
		*this = *this - x;
		return *this;
	}
	Matrix& operator*=(int x) {
		*this = *this * x;
		return *this;
	}
	bool operator==(Matrix x) {
		return v == x.v;
	}
	bool operator!=(Matrix x) {
		return !(*this == x);
	}
	friend ostream& operator<<(ostream& os, const Matrix& x) {
		for (size_t i = 0; i < x.n; i++) {
			for (size_t j = 0; j < x.m; j++)
				cout << x.v[i][j] << " ";
			cout << endl;
		}
		return os;
	}
};
//0 1
//1 2
//02
//24
int main()
{
	Matrix a;
	Matrix b(2, 2);
	Matrix c(3, 3);

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++) b[i][j] = i + j;

	b *= 2;
	b = a = b + b;
	if (a != b) cout << "Something wrong\n";
	else cout << "As expected\n";

	b += c; // эта строчка работать не должна, потому что матрицы
			// разной размерности складывать нельзя.         

	cout << a << endl
		<< c << endl
		<< b << endl;

	return 0;
}
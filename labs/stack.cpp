#include <vector>
#include <iostream>
using namespace std;
template <typename T>
class S
{
public:
	vector<T> arr;
	void push(T x) {
		if (empty()) arr.push_back(x);
		else if (x > arr[arr.size()-1]) arr.push_back(x);
	}
	T pop() {
		if (empty()) throw "arr is empty";
		else {
			T buff = arr[arr.size()-1];
			arr.erase(arr.end()-1);
			return buff;
		}
	}
	int size() {
		return arr.size();
	}
	bool empty() {
		return size() == 0;
	}
};
int main() {
	S<int> a;
	int b[10]{ 10, 2, 3, 14, 15, 9, 8, 10, 14 };
	for each (int bs in b)
	{
		a.push(bs);
		
	}
	int size = a.size();
	for (int i = 0; i < size; i++)
	{
		cout << a.pop() << " ";
	}
	return 0;
}
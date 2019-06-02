#include <fstream>
#include <string>
#include <cctype>
#include <map>
#include <vector>
#include <iostream>
#include<algorithm>
#include <utility>
using namespace std;
int main()
{
	ifstream fin;
	fin.open("in.txt");
	ofstream fouta;
	fouta.open("alphabet.txt");
	ofstream foutf;
	foutf.open("frequencies.txt");
	setlocale(LC_ALL, "Russian");
	string sentense;
	while (fin)
	{
		getline(fin, sentense);
	};
	const char *delimiters = "., \t!?";

	map<string, int> frequencies;
	size_t found = sentense.find_first_of(delimiters);
	size_t nfound = 0;
	while (found != string::npos)
	{
		size_t n = nfound;
		if (nfound < found) {
			string word = sentense.substr(nfound, found - n);
			++frequencies[word];
			nfound = sentense.find_first_not_of(delimiters, found + 1);
		}
		found = sentense.find_first_of(delimiters, found + 1);
	}

	for (const auto &p : frequencies) foutf << p.first << ": " << p.second << endl;
	vector<pair<string, int> > alphabet(frequencies.begin(), frequencies.end());
	sort(alphabet.begin(), alphabet.end(), [](auto &left, auto &right) { return left.second < right.second;});
	for (const auto &p : alphabet) fouta << p.second << ": " << p.first << endl;
	fin.close();
	fouta.close();
	
	foutf.close();
	return 0;
}
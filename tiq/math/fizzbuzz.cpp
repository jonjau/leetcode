
#include <vector>
#include <string>
#include <iostream>
#include <numeric>

using namespace std;

class Solution
{
public:
    void operator()()
    {
        auto v = fizzbuzz(20);
        for (auto const& x : v) {
            cout << x << ' ';
        }
        cout << '\n';
    }

    vector<string> fizzbuzz(int n)
    {
        vector<string> result(n);
        for (int i = 0; i < n; i++)
        {
            auto x = i + 1;
            if (x % 15 == 0)
            {
                result[i] = "FizzBuzz";
            }
            else if (x % 3 == 0)
            {
                result[i] = "Fizz";
            }
            else if (x % 5 == 0)
            {
                result[i] = "Buzz";
            }
            else
            {
                result[i] = to_string(x);
            }
        }
        return result;
    }
};
#include <iostream>
#include <chrono>
#include "../tiq/array/remove_duplicates.cpp"

int main(int argc, char const *argv[])
{
    Solution s;
    auto start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < 100000; ++i) {
        s();
    }
    auto finish = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> elapsed = (finish - start);

    std::cout << "--- " << elapsed.count() << " seconds ---\n";

    return 0;
}

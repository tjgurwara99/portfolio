#pragma once
#include<bitset>
#include<boost/multiprecision/cpp_int.hpp>
#include<string>
#include<vector>
#define cpp_int boost::multiprecision::cpp_int

std::vector <cpp_int> BinaryK(cpp_int); //convertion of long to binary

 cpp_int ModularExpo(cpp_int , std::vector<cpp_int> &K, cpp_int n); //modular exponentiations optimised using binary

cpp_int GCD(cpp_int, cpp_int); // greatest common divisor

cpp_int pow(cpp_int, cpp_int); //raising to the power

cpp_int modpow(cpp_int, cpp_int, cpp_int);  //modular exponentiation - binary function independant

bool fermatprime(cpp_int); // fermat's primality test



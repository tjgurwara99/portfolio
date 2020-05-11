#include<cstdlib>
#include<vector>
#include"prime.h"
#include<boost/multiprecision/cpp_int.hpp>
#define cpp_int boost::multiprecision::cpp_int

cpp_int GCD(cpp_int a, cpp_int b){
        while(true){
                if(a<b){
                        b = b%a;
                }
                else if(b<a){
                        a = a%b;
                }
                if(a == 0){
                        return b;
                        break;
                }
                else if(b == 0){
                        return a;
                        break;
                }
                else if( a == b && a>0){
                        return a;
                        break;
                }
        }
}

cpp_int pow(cpp_int a, cpp_int b){
	cpp_int result=1;
	for(cpp_int i=1; i<=b;i++){
		result *= a;
	}
	return result;
} 

std::vector <cpp_int> BinaryK( cpp_int k)
{
    std::vector<cpp_int> K; 
    cpp_int tmp = k;
    cpp_int n = 2;
    while (tmp > 0)
    {
        K.push_back(tmp % n);
        tmp = tmp / n;
    }

    return K;
}

 cpp_int ModularExpo( cpp_int a, std::vector<cpp_int> & K,  cpp_int n)
{
    if (n == 1)
        return 0;

    cpp_int b = 1;
    if (K.size() == 0)
        return b;
    cpp_int A = a;
    if (K[0] == 1)
        b = a;

    for (int i = 1; i < K.size(); i++)
    {
        A = A * A % n;
        if (K[i] == 1)
            b = A*b % n;
    }
    return (b);
}

cpp_int modpow(cpp_int base, cpp_int exponent, cpp_int modulus){
	if(modulus == 1)
		return 0;
	cpp_int mod = 1;
	for(cpp_int i=1;i<=exponent;i++){
		mod = (mod*base)%modulus;
	}
	return mod;
}

bool fermatprime( cpp_int a){
	cpp_int random;
	random = rand() % (a-1) ;
	random++;
	std::vector<cpp_int> v = BinaryK(a-1);
	if(GCD(random, a) != 1){
		return false;
	}
	else{
		 cpp_int p = ModularExpo(random, v, a);
		if(p == 1){
			random = rand() % (a-1);
			random++;
			p = ModularExpo(random, v, a);
			if(p == 1){
				random = rand() % (a-1);
				random++;
				p = ModularExpo(random, v, a);
				if(p == 1){
					return true;
				}
			}
		}
		else
			return false;
	}
}

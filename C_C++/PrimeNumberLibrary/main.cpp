#include<stdio.h>
#include<sstream>
#include"prime/prime.h"

int main(int argc, char** argv){
        if(argc == 2){
                cpp_int n;
                std::istringstream iss( argv[1]);
                if(iss >> n){
                        if(fermatprime(n))
					std::cout << n << " number is probably prime.\n";
			else{
				//printf("%lld number is not a prime.\n", n);
				std::cout <<  n << " number is not a prime.\n";
			}
                }
        }
	else{
		printf("Incorrect Arguments\n");
	}
}

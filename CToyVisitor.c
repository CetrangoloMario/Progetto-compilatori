#include <stdio.h>
#include <stdbool.h>
#include <string.h>

	int *int_return0;
int n = 0;

 void factorial (int n, int *int_pararametri0){
	int result = 0;

	
	if (n == 0) { 
					result = 1;

	}
	 else {
					result = n * factorial (n - 1,  &int_return0);;

	}
	*int_parametri0 = result;

	}

 void main (){
	
	while( n < 10 ){
			printf("%s" , "Enter n, or >= 10 to exit: ");
			scanf("%d", &n);
			printf("%s%d%s%d%s" , "Factorial of ", n, " is ", factorial (n,  &int_return0);, "\n");
	}

	}

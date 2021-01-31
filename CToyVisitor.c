#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int n = 0;
int i = 5;
int j = 3;
int a, b, c = 0;

 void f (int *int_parametri0, int *int_parametri1){
	
	b = n;
	c = a;
	*int_parametri0 = b;
	*int_parametri1 = c;

}


 int main (){
	int q, e;
	char t[500]  = "dsag";

	
	if (strcmp(t,"dsag") == 0) { 
			
	int int_return0;

	int int_return1;
	f ( &int_return0,  &int_return1);
	printf("%s %d %s %d%d%s " , "Factorial of ", n, " is ", int_return0, int_return1, "\n");

	}
	n = i + j;
	a = n * j;
	
	int int_return2;

	int int_return3;
	f ( &int_return2,  &int_return3);
	q = int_return2;
	e = int_return3;
	
	int int_return4;

	int int_return5;
	f ( &int_return4,  &int_return5);
	printf("%s %d %s %d%d%s " , "Factorial of ", n, " is ", int_return4, int_return5, "\n");

	 return 0;
}


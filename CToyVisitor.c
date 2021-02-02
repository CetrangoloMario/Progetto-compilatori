#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int n = 0;
int i = 5;
int j = 3;
int a, b, c = 0;

 void f (int *int_parametri0, 	char *string_parametri1){
	
	b = n;
	c = a;
	*int_parametri0 = b;
	strcpy(string_parametri1,"ciao");
}


 int main (){
	int q, e;
	char t[500]  = "dsag";

	
	if (strcmp(t,"dsag") >0) { 
			
	int int_return0;

	char string_return1[500];
	f ( &int_return0, string_return1);
	printf("%s %d %s %d%s%s " , "Factorial of ", n, " is ", int_return0, string_return1, "\n");

	}
	n = i + j;
	a = n * j;
	
	int int_return2;

	char string_return3[500];
	f ( &int_return2, string_return3);
	a = int_return2;
	strcpy(t,string_return3);
		printf("%s %d %s %s %s " , "Factorial of ", n, " is ", t, "\n");

	 return 0;
}


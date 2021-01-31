#include <stdio.h>
#include <stdbool.h>
#include <string.h>

	char nome[500]  = "Michele";

 void writeNewLines (int n){
	
		while( n > 0 ){
				printf("%s " , "\n");
		n = n - 1;
	}
	
}


 void multAddDiff (int *int_parametri0, int *int_parametri1, int *int_parametri2){
	int primo, secondo, mul, add, diff;

		printf("%s " , "Inserire il primo argomento:\n");
		scanf("%d", &primo);
		printf("%s " , "Inserire il secondo argomento:\n");
		scanf("%d", &secondo);
	mul = primo * secondo;
	add = primo + secondo;
	diff = primo - secondo;
	*int_parametri0 = mul;
	*int_parametri1 = add;
	*int_parametri2 = diff;

}


 int main (){
	int a, b, c = 0;

	
	int int_return0;

	int int_return1;

	int int_return2;
	multAddDiff ( &int_return0,  &int_return1,  &int_return2);
	a = int_return0;
	b = int_return1;
	c = int_return2;
		printf("%s %s " , "Ciao ", nome);
		writeNewLines (2);
		printf("%s %d %s %d %s %d %s " , "I tuoi valori sono:\n", a, " per la moltiplicazione\n", b, " per la somma, e \n", c, " per la differenza");

	 return 0;
}


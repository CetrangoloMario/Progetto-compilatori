#include <stdio.h>
#include <stdbool.h>
#include <string.h>


float calcolaProdotto (float n1, float n2){
	int i = 0;
float temp = 0.0;

		while( i < n2 ){
			temp = temp + n1;
		i = i + 1;
	}
	
	 return temp;

}


float calcolaEsponente (float n1, float n2){
	int i = 0;
float temp = 0.0;
float num2 = 1;

		while( i < n2 ){
			temp = temp + 	calcolaProdotto (n1, num2);
		i = i + 1;
	}
	
	 return temp;

}


float succFibonacci (float n1){
	float fib = 0.0, fib1, fib2, i;

	
	if (n1 == 0 || n1 == 1) { 
			fib = 1;

	}
	 else {
			fib1 = 1;
		fib2 = 2;
		i = 1;
			while( i < n1 ){
			fib = fib1 + fib2;
		i = i + 1;
		fib2 = fib1;
		fib1 = fib;
	}
	
	}

	 return fib;

}


float calcola (int n, float num1, float num2){
	float result = 0.0;

	
	if (n == 1) { 
			result = num1 + num2;

	}

	else { if(n == 5) {
			result = 	succFibonacci (num1);
	 }

	else { if(n == 4) {
			
	if (num2 < 0) { 
				printf("%s " , "Numero inserito non positivo non si può fare la elevazione");
		result = 0.0;

	}
	 else {
			result = 	calcolaEsponente (num1, num2);

	}
	 }

	else { if(n == 3) {
			
	if (num1 < 1) { 
				printf("%s " , "Numero inserito non positivo non si può fare la divisione");
		result = 0.0;

	}

	else { if(num2 < 1) {
				printf("%s " , "Numero inserito non positivo non si può fare la divisione");
		result = 0.0;
	 }
	 else {
			result = num1 / num2;

	}

	}
	 }

	else { if(n == 2) {
			result = 	calcolaProdotto (num1, num2);
	 }

				}

			}

		}

	}

	 return result;

}


 int main (){
	int operazione, n = 1;
float num1, num2, result;
bool flag = true;

		while( flag ){
			
	if (n != 0) { 
				printf("%s " , "Scegli operazione aritmetrica: \n");
			printf("%s " , "\n 1 = somma, 2 = moltiplicazione, 3 = divisione, 4 = elevamento a potenza, 5 = successione di Fibonacci\n\n");
			scanf("%d", &operazione);
		
	if (operazione >= 1 && operazione < 5) { 
				printf("%s " , "\n Inserisci il primo numero: \n");
			scanf("%f", &num1);
			printf("%s " , "\n Inserisci il secondo numero: \n");
			scanf("%f", &num2);
			printf("%s %f " , "Risultato è: ", 	calcola (operazione, num1, num2));

	}

	else { if(operazione == 5) {
				printf("%s " , "\n Inserisci il primo numero: \n");
			scanf("%f", &num1);
			printf("%s %f " , "Risultato è: ", 	calcola (operazione, num1, num1));
	 }
	 else {
				printf("%s " , "\tNumero inserito non valido\n");
		n = 0;
		flag = false;

	}

	}
			printf("%s " , "\t\t FINE \n\n");

	}
	}
	
	 return 0;
}


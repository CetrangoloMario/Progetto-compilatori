#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int n = 1;

 void calcola_int (int x, int y, int operazione){
	int result = 0;

	
	if (operazione == 1) { 
			result = x + y;

	}

	else { if(operazione == 4) {
			result = x / y;
	 }

	else { if(operazione == 3) {
			result = x * y;
	 }

	else { if(operazione == 2) {
			result = x - y;
	 }
	 else {
				printf("%s " , "ok");

	}

			}

		}

	}
		printf("%s %d %s %d %s %d " , "Risultato di", x, " e ", y, " :\n ", result);

}


 void calcola_double (float x, float y, int operazione){
	float result = 0.0;

	
	if (operazione == 1) { 
			result = x + y;

	}

	else { if(operazione == 4) {
			result = x / y;
	 }

	else { if(operazione == 3) {
			result = x * y;
	 }

	else { if(operazione == 2) {
			result = x - y;
	 }
	 else {
				printf("%s " , "ok");

	}

			}

		}

	}
		printf("%s %f %s %f %s %f " , "Risultato di", x, " e ", y, " :\n ", result);

}


 int main (){
	int operazione, tipo_num = 0;
int x, y = 0;
float z, w = 0.0;
bool flag = false;

		while( n == 1 ){
			
	if (n != 0) { 
				printf("%s " , "Scegli operazione aritmetrica: ");
			printf("%s " , "\n 1 = somma, 2 = differenza, 3 = moltiplicazione, 4 = divisione");
			scanf("%d", &operazione);
			printf("%s " , "Operazioni effettui su interi o double, 1 o 2");
			scanf("%d", &tipo_num);
		
	if (tipo_num == 1) { 
				printf("%s " , "\n Inserisci il primo numero: \n");
			scanf("%d", &x);
			printf("%s " , "\n Inserisci il secondo numero: \n");
			scanf("%d", &y);
			calcola_int (x, y, operazione);

	}
		
	if (tipo_num == 2) { 
				printf("%s " , "\n Inserisci il primo numero: \n");
			scanf("%f", &z);
			printf("%s " , "\n Inserisci il secondo numero: \n");
			scanf("%f", &w);
			calcola_double (z, w, operazione);

	}
			while( flag == false ){
				printf("%s " , "Vuoi continuare: inserisci 0 per terminare altrimenti 1.\n");
			scanf("%d", &n);
		
	if (n == 0) { 
				printf("%s " , " Arrivederci\n\n");
		flag = true;

	}

	else { if(n != 1) {
			flag = false;
	 }
	 else {
			flag = true;

	}

	}
	}
	
	}
	}
	
	 return 0;
}


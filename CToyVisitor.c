#include <stdio.h>
#include <stdbool.h>
#include <string.h>


 voidprintPeg (int peg){
	
	
	if (peg== 1) { 
					printf("%s " , "left");

	}

	else { if(peg== 2) {
					printf("%s " , "center");
	 }
	 else {
					printf("%s " , "right");

	}

	}

	}

 voidhanoi (int n, int fromPeg, int usingPeg, int toPeg){
	
	
	if ( != 0) { 
				hanoi (n - 1, fromPeg, toPeg, usingPeg);
			printf("%s " , "Move disk from ");
		printPeg (fromPeg);
			printf("%s " , " peg to ");
		printPeg (toPeg);
			printf("%s " , " peg.\n");
		hanoi (n - 1, usingPeg, fromPeg, toPeg);

	}

	}

 int main (){
	int n = 0;

		printf("%s " , "How many pegs? ");
		scanf("%d", &n);
	hanoi (n, 1, 2, 3);

	 return 0;
	}

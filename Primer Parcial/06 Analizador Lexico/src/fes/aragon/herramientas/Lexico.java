package fes.aragon.herramientas;

public class Lexico {
	private String tokenActual = "";
	
	private int indice = 0;
	// Variables del AFD
	private int estado = 0;
	private int columna = 0;
	private Character numero = 'D';
	private Character letra = 'L';
	private boolean espacio = false;
	private boolean tokenEvaluado = false;

	private String token = "";

	public Lexico() {
		super();
	}

	private void reinicio() {
		estado = 0;
		columna = 0;
		tokenActual  = "";

	}

	public void setToken(String token) {
		this.token = token;
	}

	private char siguienteCaracter() throws Exception {
		char caracter = ' ';
		if (indice < token.length()) {
			caracter = token.charAt(indice);
			if (caracter == ' ' && indice < token.length()) {
				espacio = true;
			}
			indice++;
		}
		return caracter;
	}

	public void/*int*/ inicio(int[][] matriz, Character[] lenguaje) throws Exception {
		char c = ' ';
		reinicio();
		indice = 0;
		tokenActual = "";
		do {
			boolean caracterEncontrado = false;
			boolean caracterUsuarioEncontrado = false;
			espacio = false;
			c = siguienteCaracter();
			if(!espacio && !Herramienta.finCadena(c)) {
				tokenActual = tokenActual + c;
				}
				if (Herramienta.numero(c) || Herramienta.letra(c)) { //Anliza los caracteres que sean letras o digitos, para diferenciar entre los declarados por el usuario y los L y D
					for (int j = 0; j < lenguaje.length; j++) {			
						if (c == lenguaje[j]) { //Si son del Lenguaje del usuario, registra la columna donde lo encontro
							columna = j;
							caracterEncontrado = true;
							caracterUsuarioEncontrado = true; //Activa las banderas, encontro un caracter en el lenguaje y lo encontro dentro de los del usuario
							break;
						}
					}
					if (!caracterUsuarioEncontrado) { //Si el caracter NO est� dentro del lenguaje del usuario
						if (Herramienta.numero(c)) {
							for (int j = 0; j < lenguaje.length; j++) {
								if (numero == lenguaje[j]) { //Comprueba si esta entre los digitos, si lo esta, registra su columna
									columna = j;
									caracterEncontrado = true;
									break;
								}
							}
						} else {
							for (int j = 0; j < lenguaje.length; j++) {
								if (letra == lenguaje[j]) { //Comprueba si esta entre las letras, si lo esta, registrala
									columna = j;
									caracterEncontrado = true;
									break;
								}
							}
						}
					}
				} else if (!Herramienta.numero(c) && !Herramienta.letra(c) && !Herramienta.finCadena(c) && !espacio) { //Si el caracter no entra en el grupo de digitos o letras, busca en el lenguaje del usuario
					for (int j = 0; j < lenguaje.length; j++) {
						if (c == lenguaje[j]) { // Lenguaje usuario
							columna = j; // Si lo encuentra, registra en que columna no encontro
							caracterEncontrado = true;
							break;
						}
					}
				} else if (Herramienta.finCadena(c) || espacio ) {
					if(espacio) {
								estado = matriz[estado][lenguaje.length-1];
								columna = matriz[0].length - 1;
								estado = matriz[estado][columna];
								//return estado;
								if (estado == 1) {
									System.out.println(tokenActual + ": Cadena valida");
									reinicio();
									tokenEvaluado = true;
								} else {
									System.out.println(tokenActual + ": Cadena invalida");
									reinicio();
									tokenEvaluado = true;
								}
					}else {
						columna = matriz[0].length - 1;	 //si encontro el fin de la cadena ' ', marca si el estado es final o no seg�n nuestra matriz
						estado = matriz[estado][columna];
						if (estado == 1) {
							System.out.println(tokenActual + ": Cadena valida");
							reinicio();
							tokenEvaluado = true;
						} else {
							System.out.println(tokenActual + ": Cadena invalida");
							reinicio();
							tokenEvaluado = true;
						}
						//caracterEncontrado = true;
					}
				}
				if (caracterEncontrado) { //Si encontr� un caracter, registra el estado(Posteriormente la fila en la mtriz) y la columna en la que fue encontrado 
					estado = matriz[estado][columna];
				}else if(tokenEvaluado) {
					tokenEvaluado = false;
				}else {
					throw new Exception(token + ": Caracter invalido ---> " + c + " encontrado en la columna: " + (indice));
				}
//			}else {
//				reinicio();
//				System.out.println(tokenActual);
//			}


		} while (!Herramienta.finCadena(c));
		//return estado;
	}

}
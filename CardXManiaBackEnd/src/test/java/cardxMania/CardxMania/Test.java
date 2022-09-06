package cardxMania.CardxMania;

import java.util.Scanner;

import cardxMania.model.Admin;
import cardxMania.model.Compte;
import cardxMania.model.User;

public class Test {


	static Compte connected;
//	static DAOCompte daoC = new DAOCompte();
//	static DAOAdmin daoAd = new DAOAdmin();
//	static DAOAchat daoAc = new DAOAchat();
//	static DAOExemplaire daoE = new DAOExemplaire();
//	static DAOUser daoU = new DAOUser();

	static Integer code = 0;
	static Integer total = 0;


	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int val =sc.nextInt();
		return val;
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}

	public static void menuPrincipal() 
	{
		System.out.println("1- Se connecter");
		System.out.println("2- Inscription");
		System.out.println("3- Fermer");
		int choix = saisieInt("Choisir un menu");


		switch(choix) {
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);
		}
		menuPrincipal();
	}

//ADMIN

	//Menu admin
	public static void menuAdmin()

	{
		System.out.println("Menu Admin");

		System.out.println("1 - ajouter une carte a la base de donnees");
		System.out.println("2 - verifier l'etat d'un exemplaire");
		System.out.println("3 - encadrer les transferts");
		System.out.println("4 - Se deconnecter");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : ajoutCarte();break;
		case 2 : verifierEtat();break;
		case 3 : encadreTransfert();break;
		case 4 : seDeconnecter();break;
		}
		menuAdmin();

		//Ajouter une carte a la base de données
	}
	private static void seDeconnecter() {
		// TODO Auto-generated method stub

	}


	private static void encadreTransfert() {
		// TODO Auto-generated method stub

	}

	private static void verifierEtat() {
		// TODO Auto-generated method stub

	}

	private static void ajoutCarte() {
		// TODO Auto-generated method stub

	}



//USER		


	public static void menuUser()
	{
		System.out.println("Menu User");

		System.out.println("1 - creer un exemplaire d'une carte");
		System.out.println("2 - Listes exemplaires present dans ma collection");
		System.out.println("3 - Cote de ma collection");
		System.out.println("4 - Choisir une carte/ un lot et la mettre en vente");
		System.out.println("5 - Se deconnecter");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : creationExemplaire();break;
		case 2 : listeExemplaire();break;
		case 3 : coteDeLaCollection();break;
		case 4 : mettreEnVente();break;
		case 5 : seDeconnecter();break;
		}
		menuUser();


		//Créer exemplaire d'une carte (série + état)
		//Retouner la liste de mes exemplaires
		//Retourner la cote de ma collection
		// Choisir une carte et la mettre en vente + mettre en vente un lot ?


		//Se déconnecter
	}



	private static void mettreEnVente() {
		// TODO Auto-generated method stub

	}

	private static void coteDeLaCollection() {
		// TODO Auto-generated method stub

	}

	private static void listeExemplaire() {
		// TODO Auto-generated method stub

	}

	private static void creationExemplaire() {
		// TODO Auto-generated method stub

	}

	public static void inscription() {
		System.out.println("inscription :");
		String pseudo = saisieString("Saisir votre login :");
		String password = saisieString("Saisir votre password :");
		String mail = saisieString("Saisir votre mail : ");


		User u = new User(pseudo,password,mail);
		//daoC.insert(u);
		System.out.println("Vous etes inscrits, BIENVENUE ! ");

	}



	//ADMIN+USER	
	public static void connexion() 
	{
		String pseudo = saisieString("Saisir votre pseudo");
		String password = saisieString("Saisir votre password");
		//connected = daoC.seConnecter(pseudo, password);

		if(connected instanceof Admin) 
		{

			menuAdmin();
		}

		else if(connected instanceof User) 
		{

			menuUser();

		}
		else {System.out.println("Identifiants invalides");}
	}




	public void run(String[] args) {
		
		//menuPrincipal();
		//inscription();


//test gitkraken louis

	}

}

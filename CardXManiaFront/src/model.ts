export  class Compte {
	id: number;
    pseudo: string;
    password: string;
    mail: string;
    activated: boolean;
    role:string;

    exemplaire: Array<Exemplaire> = new Array<Exemplaire>();
    ventes: Array<Lot> = new Array<Lot>();
    achats: Array<Lot> = new Array<Lot>();


constructor(id?: number, pseudo?: string, password? : string, mail?: string, activated?: boolean, role?: string) {
    this.id = id;
    this.pseudo = pseudo;
    this.password = password;
    this.mail = mail;
    this.activated = activated;
    this.role = role;
}

	
}
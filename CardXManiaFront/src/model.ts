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


    constructor(role?: string, id?: number, pseudo?: string, password? : string, mail?: string, activated?: boolean ) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.mail = mail;
        this.activated = activated;
        this.role = role;
    }
}


export class Exemplaire {
    id: number;
    enVente: boolean;
    valeurExemplaire: number;
    etat: string;

    carte: Carte;
    user: Compte
    achats: Array<Achat> = new Array<Achat>();
    

    constructor(id?: number, achats?: Array<Achat>, user?: Compte, enVente?: boolean, valeurExemplaire?: number, carte?: Carte) {
        this.id = id;
        this.achats = achats;
        this.user = user;
        this.enVente =  enVente;
        this.valeurExemplaire = valeurExemplaire;
        this.carte = carte;
    }
    
}

export class Lot {
    id: number;
    note: number;
    dateAchat: string;
    acheteur: User;
    vendeur: User;
    
    constructor(id?: number, note?: number, acheteur?: User, vendeur?: User, dateAchat?: string ){
        this.id = id;
        this.note = note;
        this.acheteur = acheteur;
        this.vendeur = vendeur;
        this.dateAchat = dateAchat;
    }

}

export class Achat {
    id: number;
    exemplaire: Exemplaire;
    lot: Lot;

    constructor(id?: number, exemplaire?: Exemplaire, lot?: Lot){
        this.id = id;
        this.exemplaire = exemplaire;
        this.lot = lot;
    }
}

export class Carte {
    id: number;
    cote: number;
    libelle: string;
    description: string;
    serie: string;

    constructor(id?:number, cote?: number, libelle?: string, description?: string, serie?: string){
        this.id = id;
        this.cote = cote;
        this.libelle = libelle;
        this.description = description;
        this.serie = serie;
    }
}

export class User extends Compte {

    constructor(id?: number, pseudo?: string, password? : string, mail?: string, activated?: boolean, role?: string) {
        super(role,id, pseudo, password, mail, activated);
    }
}

export class Admin extends Compte {

}
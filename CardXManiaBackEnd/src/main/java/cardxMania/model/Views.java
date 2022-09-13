package cardxMania.model;

public class Views {

	public static class ViewBase {
	}
	
	public static class ViewAchat extends ViewBase {
	}
	
	public class ViewAchatWithLot  extends ViewAchat{
	}
	
	public class ViewAchatWithExemplaire extends ViewAchat {	
	}
	

	public static class ViewAdmin extends ViewBase {
	}
	
	
	public static class ViewCarte extends ViewBase {
	}
	
	public static class ViewCarteWithCompte extends ViewCarte {	
	}
	public static class ViewCarteWithSerie extends ViewCarte {	
	}
	
	public static class ViewCartewithExemplaire extends ViewCarte {	
	}
	
	public static class ViewCompte extends ViewBase {
	}
	
	public static class ViewCompteWithExemplaire extends ViewCompte {	
	}
	
	public static class ViewCompteWithLot  extends ViewCompte {
	}
	
	
	public static class ViewExemplaire extends ViewBase {
	}
	
	public class ViewExemplaireWithAchat extends ViewExemplaire {	
	}
	
	public class ViewsExemplaireWithCarte extends ViewExemplaire {	
	}
	
	
	public static class ViewLot extends ViewBase {
	}
	
	public static class ViewLotWithAchat extends ViewLot {
	}
	
	public static class ViewUser extends ViewBase {
	}
}

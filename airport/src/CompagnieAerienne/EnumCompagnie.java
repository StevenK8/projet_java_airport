package CompagnieAerienne;

import Personnes.Pays;

public enum EnumCompagnie {

	 American_Airlines (Pays.EtatsUnis),
	 Air_Canada (Pays.Canada),
	 Air_France (Pays.France),
	 Air_Algerie (Pays.Algerie),
	 Air_India (Pays.Algerie),
	 Aerolineas_Argentinas (Pays.Argentine),
	 Royal_Air_Maroc (Pays.Maroc),
	 Finnair (Pays.Finlande),
	 Alitalia (Pays.Italie),
	 Air_China (Pays.Chine),
	 Cathay_Pacific (Pays.Chine),
	 Delta_Airlines (Pays.EtatsUnis),
	 Aer_Lingus (Pays.Irlande),
	 Emirates (Pays.Chine),
	 Ethiopian_Airlines (Pays.Dubai),
	 Icelandair (Pays.Islande),
	 Hawaiian_Airlines (Pays.EtatsUnis),
	 Japan_Airlines (Pays.Japon),
	 KLM (Pays.France),
	 Air_Malta (Pays.Malte),
	 LOT_Polish_Airlines (Pays.Pologne),
	 Air_Madagascar (Pays.Madagascar),
	 Air_Mauritius (Pays.Mauritanie),
	 Austrian_Airlines (Pays.Autriche),
	 Qatar_Airways (Pays.Qatar),
	 South_African_Airways (Pays.AfriqueduSud),
	 Scandinavian_Airlines (Pays.Islande),
	 Brussels_Airlines (Pays.Belgique),
	 Singapore_Airlines (Pays.Chine),
	 Corsair (Pays.France),
	 Thai_Airways (Pays.Thailande),
	 Turkish_Airlines (Pays.Turquie),
	 TAP_Portugal (Pays.Portugal),
	 Tunisair (Pays.Tunisie),
	 Air_Caraibes (Pays.France),
	 United_Airlines (Pays.EtatsUnis),
	 Air_Austral (Pays.Australie),
	 Air_Europa (Pays.France),
	 Easyjet (Pays.Angleterre),
	 Vietnam_Airlines (Pays.Vietnam),
	 Air_Corsica (Pays.France),
	 Air_Tahiti_Nui (Pays.France),
	 Aigle_Azur (Pays.France), 
	 Jet_Airways (Pays.Angleterre),
	 Etihad_Airways (Pays.Arabie),
	 Ryanair_LTD (Pays.Angleterre),
	 Vueling (Pays.Allemagne),
	 Norwegian (Pays.Norvege),
	 Transavia_France (Pays.France),
	 Germanwings (Pays.Allemagne),
	 TUI_Fly_Belgium (Pays.Belgique),
	 Air_Arabia (Pays.Arabie),
	 Air_Asia (Pays.Chine);
	
	private Pays nationalite;
	
	private EnumCompagnie(Pays pNationalite) {
		this.nationalite = pNationalite;
	}
	public Pays getPaysFromCompagnie() {
		return nationalite;
	}
}

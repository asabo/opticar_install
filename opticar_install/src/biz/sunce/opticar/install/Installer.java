package biz.sunce.opticar.install;

import java.io.File;

import biz.sunce.util.ZipUtil;

public final class Installer 
{

	public static final void instalirajBazu(String konfiguracijskiDirektorijKorisnika){
		System.out.println("Provjera ispravnosti baze podataka..");	
		 File di=new File(konfiguracijskiDirektorijKorisnika);
		 
		 String abs=di.getAbsolutePath();
		 String sep=System.getProperty("file.separator");
		 String baza=abs+sep+"opticardb";
		 File fbaza=new File(baza);
		 if (fbaza.exists()){
			 System.out.println("Direktorij "+fbaza.getAbsolutePath()+" vec postoji, necemo updateati bazu!");
			 return;
		 }
		 System.out.println("Instalacija zapocinje");	
		 System.out.println("Konf dir: "+di.getAbsolutePath());
		
		ZipUtil.extractZipStreamFromClasspath("biz/sunce/opticar/data/opticardb.zip", di);
		System.out.println("zavrseno!");
	}
    
}

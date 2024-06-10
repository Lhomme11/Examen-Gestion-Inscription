import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;
import entities.Professeur;
import entities.ProfesseurEtClasse;
import services.ClasseService;
import services.ProfesseurService;

public class RpView {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        //Dependances
        ClasseService classeService=new ClasseService();
        ProfesseurService professeurService=new ProfesseurService();
        do {
            System.out.println("1-Creer une classe");
            System.out.println("2-Lister les classes"); 
            System.out.println("3-Ajouter un professeur et lui affecter une classe"); 
            System.out.println("4-Lister les professeurs en affichants la classe");
            System.out.println("5-Filtrer les classes d'un professeur");
            System.out.println("6-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                    int choixNiveau;
                    do {
                    System.out.println("Choisissez le niveau : 1-L1; 2-L2; 3-L3; 4-M1; 5-M2");    
                    choixNiveau=sc.nextInt();
                    } while (choixNiveau<1 || choixNiveau>3);
                    Niveau niveau = Niveau.values()[choixNiveau-1];
                    System.out.println("Choisissez la filière : 1-IAGE; 2-GLRS; 3-CPD; 4-CDSD; 5-MOSIEF; 6-MAIE; 7-TTL; 8-ETSE");
                    int choixFiliere=sc.nextInt();
                    Filiere filiere=Filiere.values()[choixFiliere-1];
                    Classe classe=new Classe();
                    classe.setNiveau(niveau);
                    classe.setFiliere(filiere);
                    classeService.ajouterClasse(classe);
                    break;
                
                case 2:
                    System.out.println("Les classes sont les suivantes:");
                    List<Classe> classes=classeService.listerClasse();
                    for (Classe cl : classes ) {
                        System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
                    }
                    break;

                    case 3:
                Professeur professeur=new Professeur();
                  System.out.println("Entrer le numéro de la carte d'identité du professeur");
                  professeur.setNci(sc.nextInt());
                  sc.nextLine() ;
                  System.out.println( "Entrer le nom complet");
                  professeur.setNomComplet(sc.nextLine());
                  System.out.println( "Entrer le grade");
                  professeur.setGrade(sc.nextLine());

            
                    classes = classeService.listerClasse();
                    int response=2;
                    List<ProfesseurEtClasse> ListeClasseProf = new ArrayList<>();
                    do {
                        for (Classe cl : classes) {
                            System.out.println(cl.getId()+"-"+cl.getNiveau()+"-"+cl.getFiliere());
                          }
                         System.out.println("Veuillez selectionner la  classe que vous voulez affecter");
                          int idClasse=sc.nextInt(); 
                          classe= classeService.chercherClasseById(idClasse);
                          if (classe!=null) {
                             ProfesseurEtClasse professeurEtClasse =new ProfesseurEtClasse();
                             professeurEtClasse.setClasse(classe);
                                int inside=0;
                                if (ListeClasseProf.size()>0) {
                                    for (ProfesseurEtClasse List:ListeClasseProf){
                                        if (List.getClasse().getId() == classe.getId()) {
                                            inside=1;
                                            System.out.println("Cette classe est déjà affectée au Professeur");
                                        }
                                        }
                                        if (inside==0) {
                                            ListeClasseProf.add(professeurEtClasse);                                            
                                        }
                                }else{
                                        ListeClasseProf.add(professeurEtClasse);                                            
                                }
                          }else{
                             System.out.println("Cet Id n'existe pas");
                          }                          
                         System.out.println("Voulez-vous continuez: 1-Oui 2-Non"); 
                         response=sc.nextInt(); 
                       
                    } while (response==1);

                    professeur.setProfesseurEtClasse(ListeClasseProf);
                    if (professeur.getProfesseurEtClasse().size()<1) {
                        System.out.println("Le professeur doit avoir au moins une classe");
                    }else{
                        professeurService.ajoutProfesseur(professeur);
                    }
                    
                  
                    break;
                   case 4:
                   System.out.println("Voici les Professeurs:");
                    List<Professeur> professeurs = professeurService.listeProfesseurs();
                    for (Professeur professeur2 : professeurs) {
                        System.out.println(professeur2.getGrade()+"/"+professeur2.getNomComplet());
                    }
                    break;
                     case 5:
                    System.out.println("Voici les professeurs:");
                    professeurs = professeurService.listeProfesseurs();
                    for (Professeur professeur2 : professeurs) {
                        System.out.println(professeur2.getId() + "-" + professeur2.getGrade() + "/" + professeur2.getNomComplet());
                    }
                    System.out.println("Entrer l'id du professeur");
                    int idProfesseur = sc.nextInt();
                    professeur = professeurService.selectProfesseurById(idProfesseur);
                    if (professeur != null) {
                    List<ProfesseurEtClasse> professeurEtClasses=professeur.getProfesseurEtClasse();
                    
                    for (ProfesseurEtClasse pc : professeurEtClasses) {
                        System.out.println(pc.getClasse().getNiveau()+" "+pc.getClasse().getFiliere());
                        }
                    } else {
                        System.out.println("Professeur introuvable.");
                    }
                    break;
                default:
                    break;
            }

        } while (choix!=6);
    }
}

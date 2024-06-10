import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import services.ClasseService;
import services.EtudiantService;
import services.InscriptionService;

public class AttacheView {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        EtudiantService etudiantService=new EtudiantService();
        ClasseService classeService=new ClasseService();
        InscriptionService inscriptionService=new InscriptionService();
        
        //Dependances
       
        do {
            System.out.println("1-Faire une inscription ");
            System.out.println("2-Lister les étudiants inscrits dans une année"); 
            System.out.println("3-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                Inscription inscription=new Inscription();
                System.out.println("Entrer le matricule de l'étudiant");
                String matricule = sc.nextLine();
                inscription=new Inscription();
                inscription=inscriptionService.chercherInscriptionEtudiantByMat(matricule);
                Etudiant etudiant= new Etudiant();
                etudiant=etudiantService.chercherEtudiantByMat(matricule);
                if(etudiant==null) {
                    System.out.println("L'etudiant n'existe pas. Veuillez l'inscrire");
                    System.out.println("Entrer le matricule de l'etudiant :");
                    matricule =sc.nextLine();
                    System.out.println( "Veuiller entrer le nom complet de l'etudiant : ");
                    String nomComplet=sc.nextLine();
                    System.out.println( "Veuiller entrer le tuteur de l'etudiant : ");
                    String tuteur=sc.nextLine();
                    etudiant=new Etudiant();
                    etudiant.setMatricule(matricule);
                    etudiant.setNomComplet (nomComplet);
                    etudiant.setTuteur (tuteur);
                    etudiantService.ajoutEtudiant(etudiant);
                }else {
                    System.out.println("L'etudiant existe déjà.Veuillez le réinscrire");
                }
                System.out.println("Saisir l'année d'inscription");
                String anneeScolaire=sc.nextLine();
                System.out.println("Les classes sont les suivantes:");
                List<Classe> classes=classeService.listerClasse();
                for (Classe cl : classes ) {
                    System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
                }
                int idClasse=sc.nextInt();
                Classe classe=new Classe();
                classe=classeService.chercherClasseById(idClasse);
                inscription.setClasse(classe);
                inscription.setAnneeScolaire(anneeScolaire);
                inscription.setEtudiant(etudiant);
                inscriptionService.ajouterInscription(inscription);
                
                break;
                               
                case 2:
                System.out.println("Veuillez saisir l'annee d'inscription");
                anneeScolaire=sc.nextLine() ;
                List<Inscription> inscriptions=inscriptionService.listeInscriptionParAnnee(anneeScolaire);
                for (Inscription inscri : inscriptions ) {
                    System.out.println("Matricule"+ inscri.getEtudiant().getMatricule()+"Nom Complet"+inscri.getEtudiant().getNomComplet()+" Tuteur"+inscri.getEtudiant().getTuteur());
                }
                System.out.println("Filtrer cette liste par classe ? oui/non");
                String reponse=sc.nextLine();
                if (reponse.equalsIgnoreCase("oui")) {
                    System.out.println("Les classes sont les suivantes:");
                    classes=classeService.listerClasse();
                    for (Classe cl : classes ) {
                        System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
                    }
                    idClasse=sc.nextInt();
                    inscriptions=inscriptionService.listeInscriptionParAnnee(anneeScolaire,idClasse);
                    for (Inscription inscri : inscriptions ) {
                    System.out.println("Matricule"+ inscri.getEtudiant().getMatricule()+"Nom Complet"+inscri.getEtudiant().getNomComplet()+" Tuteur"+inscri.getEtudiant().getTuteur());
                }
                }else if (reponse.equalsIgnoreCase("non")) {
                    break;
                }
                    break;
                    
                default:
                    break;
            }

        } while (choix!=3);
    }
}


package schedulingVideo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Scheduler{
	int tempo;
	List<Video> listaVideo;
	Video ultimoVideo;

	public Scheduler(List<Video> listaVideo,int tempoMinuti){
		tempo=tempoMinuti*60;
		this.listaVideo=listaVideo;
	}
	private boolean controllo(int indiceCasuale) {
		if(ultimoVideo != listaVideo.get(indiceCasuale) && listaVideo.get(indiceCasuale).esStimate!=0 ) {
			return true;
		}
		return false;
	}
	public void  esegui() {
		Random rand = new Random();
		int tempoDiviso = tempo/listaVideo.size();
		for(int i=0;i<listaVideo.size();i++) {
			listaVideo.get(i).esStimate=tempoDiviso/(int) listaVideo.get(i).durata;
		}
		while(listaVideo.get(0).esStimate!=0) {
			listaVideo.sort((a, b) -> b.esStimate - a.esStimate);
			int indiceCasuale = rand.nextInt(listaVideo.size());
			if(controllo(indiceCasuale)) {
				System.out.println("---------");
				System.out.println(listaVideo.get(indiceCasuale).nome);
				System.out.println(listaVideo.get(indiceCasuale).esStimate);
				ultimoVideo=listaVideo.get(indiceCasuale);
				listaVideo.get(indiceCasuale).esStimate--;
			}
		}
	}
	public static List<Integer> leggiFile() {
		List<Integer> lista=new ArrayList<>();
		try(FileReader flussoCaratteri = new FileReader("video.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
				) {
				String rigaLetta;
				do {
					rigaLetta = lettoreDiRighe.readLine();
					if(rigaLetta!=null) {
						lista.add(Integer.parseInt(rigaLetta));
					}
				}while(rigaLetta!=null);
			} catch (FileNotFoundException e) {
				System.out.println("Il file non esiste");
			} catch (IOException e) {
				System.out.println("Errore");
			}catch (NumberFormatException e) {
				System.out.println("Inserita stringa al posto di un numero");
			}
		return lista;
	}
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList();
		Scheduler x = new Scheduler(Video.vettore(leggiFile()),60);
		x.esegui();
	}
}

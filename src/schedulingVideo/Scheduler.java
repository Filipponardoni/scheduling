package schedulingVideo;

import java.util.Arrays;
import java.util.List;
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
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(30, 29, 31, 29, 30, 31, 32);
		Scheduler x = new Scheduler(Video.vettore(lista),60);
		x.esegui();
	}
}

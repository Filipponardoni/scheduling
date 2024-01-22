package schedulingVideo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Scheduler{
	int numeroVideo;
	int tempo;
	List<Video> listaVideo;
	int ultimoVideo = 1;
	int[] volteStimate;

	public Scheduler(List<Video> listaVideo,int tempoMinuti){
		tempo=tempoMinuti*60;
		this.listaVideo=listaVideo;
	}
	public void  esegui() {
		for(int i=0;i<listaVideo.size();i++) {
			System.out.println(listaVideo.get(i).nome);
		}
		numeroVideo = listaVideo.size();
		volteStimate = new int[numeroVideo] ;
		int tempoDiviso = tempo/numeroVideo;
		for(int i=0;i<numeroVideo;i++) {
			volteStimate[i]=tempoDiviso/(int) listaVideo.get(i).durata;
			listaVideo.get(i).esStimata = volteStimate[i];
		}
		while(listaVideo.get(0).esStimata!=0) {
			listaVideo.sort((a, b) -> b.esStimata - a.esStimata);
			if(ultimoVideo!= 0) {
				System.out.println(listaVideo.get(0).nome);
				System.out.println(listaVideo.get(0).esStimata);

				ultimoVideo=0;
				listaVideo.get(0).esStimata--;
			}else {
				System.out.println(listaVideo.get(1).nome);
				System.out.println(listaVideo.get(1).esStimata);
				ultimoVideo=1;
				listaVideo.get(1).esStimata--;

			}
//			System.out.println("----------");

		}
	}
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(8, 10, 7, 9, 11, 13);
		Scheduler x = new Scheduler(Video.vettore(lista),60);
		x.esegui();
	}
}

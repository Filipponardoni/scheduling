package schedulingVideo;

import java.util.Arrays;
import java.util.List;


public class Scheduler{
	int tempo;
	List<Video> listaVideo;

	public Scheduler(List<Video> listaVideo,int tempoMinuti){
		tempo=tempoMinuti*60;
		this.listaVideo=listaVideo;
	}
	public void  esegui() {
		int numeroVideo = listaVideo.size();
		int[] volteStimate= new int[numeroVideo] ;
		int[] volteEseguite= new int[numeroVideo] ;
		int tempoDiviso = tempo/numeroVideo;
		for(int i=0;i<numeroVideo;i++) {
			volteEseguite[i]=tempoDiviso/(int) listaVideo.get(i).durata;
		}
	}
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(8, 10, 5, 15, 24, 17);
		Scheduler x = new Scheduler(Video.vettore(lista),60);
	}
}

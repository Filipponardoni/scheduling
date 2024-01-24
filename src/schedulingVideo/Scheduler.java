package schedulingVideo;

import java.util.Arrays;
import java.util.List;

public class Scheduler{
	int tempo;
	List<Video> listaVideo;
	Video ultimoVideo;

	public Scheduler(List<Video> listaVideo,int tempoMinuti){
		tempo=tempoMinuti*60;
		this.listaVideo=listaVideo;
	}
	public void  esegui() {
		int tempoDiviso = tempo/listaVideo.size();
		for(int i=0;i<listaVideo.size();i++) {
			listaVideo.get(i).esStimate=tempoDiviso/(int) listaVideo.get(i).durata;
		}
		while(listaVideo.get(0).esStimate!=0) {
			listaVideo.sort((a, b) -> b.esStimate - a.esStimate);
			if(ultimoVideo!= listaVideo.get(0)) {
				System.out.println("---------");
				System.out.println(listaVideo.get(0).nome);
				System.out.println(listaVideo.get(0).esStimate);
				ultimoVideo=listaVideo.get(0);
				listaVideo.get(0).esStimate--;
			}else {
				System.out.println("---------");
				System.out.println(listaVideo.get(1).nome);
				System.out.println(listaVideo.get(1).esStimate);
				ultimoVideo=listaVideo.get(1);
				listaVideo.get(1).esStimate--;

			}
		}
	}
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(18, 18, 17, 19, 20);
		Scheduler x = new Scheduler(Video.vettore(lista),60);
		x.esegui();
	}
}

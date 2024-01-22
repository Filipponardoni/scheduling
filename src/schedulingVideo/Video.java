package schedulingVideo;

import java.util.ArrayList;
import java.util.List;

public class Video {
	double durata;
	String nome="";
	double tempoInEsecuzione;
	public int esStimata;
	static List<Video> vettoreVideo= new ArrayList<>();
	public Video(int durataSecondi) {
		durata=durataSecondi;
		tempoInEsecuzione=0;
	}
	
	public static List<Video> vettore(List<Integer> lista){
		for(int i=0;i<lista.size();i++) {
			Video x = new Video(lista.get(i));
			x.nome="v"+i;
			vettoreVideo.add(x);
		}
		return vettoreVideo;
	}
	public static void main(String[] args) {
		
	}
}

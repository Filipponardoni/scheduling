package schedulingVideo;

import java.util.ArrayList;
import java.util.List;

public class Video {
	int n = 0;
	double durata;
	String nome;
	double tempoInEsecuzione;
	static List<Video> vettoreVideo= new ArrayList<>();
	public Video(int durataSecondi) {
		nome="v"+n;
		n++;
		durata=durataSecondi;
		tempoInEsecuzione=0;
	}
	
	public static List<Video> vettore(List<Integer> lista){
		for(int i=0;i<lista.size();i++) {
			Video x = new Video(lista.get(i));
			vettoreVideo.add(x);
		}
		return vettoreVideo;
	}
	public static void main(String[] args) {
		
	}
}

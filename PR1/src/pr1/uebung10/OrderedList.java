package pr1.uebung10;
import pr.MakeItSimple.PRException;

public interface OrderedList {
/**
* Fuegt das Objekt der Klasse Song so in die Liste ein,
* dass alle Song-Namen in der Liste lexikographisch geordnet sind.
*/
void insert(Song song);
/**
* Liefert die Position der Liste, an der sich der Song mit dem
* angegebenen Namen befindet; dabei hat die erste Listenposition
* die Positionsnummer 0.
* Ist kein Song mit dem angegebenen Namen in der Liste enthalten,
* dann liefert die Methode -1 als Ergebnis.
*/
int indexOf(String songName);
/**
* Loescht den Song an der angegebenen Position aus der Liste;
* dabei hat die erste Listenposition die Positionsnummer 0.
* @throws PRException wenn die Positionsangabe ungueltig ist.
*/
void delete(int position) throws PRException;
/**
* Liefert die Laenge der Liste, d.h. die Anzahl der Listenelemente.
*/
int size();
/**
* Liefert den Song an der angegebenen Position der Liste;
* dabei hat die erste Listenposition die Positionsnummer 0.
* @throws PRException wenn die Positionsangabe ungueltig ist.
*/
Song get(int position) throws PRException;
}

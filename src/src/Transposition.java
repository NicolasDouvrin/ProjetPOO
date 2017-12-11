public class Transposition {
}
  /**  unit uTransposition;

    interface

    uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
          Dialogs, StdCtrls, Buttons, uFonctions;

    type
    TForm1 = class(TForm)
    eMessage: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    eCle: TEdit;
    bCrypter: TBitBtn;
    bFermer: TBitBtn;
    eResultat: TEdit;
    Label3: TLabel;
    bDecrypter: TBitBtn;
    procedure eCleChange(Sender: TObject);
    procedure eMessageChange(Sender: TObject);
    procedure bCrypterClick(Sender: TObject);
    procedure bDecrypterClick(Sender: TObject);
    private
    { Déclarations privées }
    public
    { Déclarations publiques }
    end;

    var
    Form1: TForm1;

    implementation

    {$R *.dfm}

    //Quand on fait un changement dans eCle
    procedure TForm1.eCleChange(Sender: TObject);
    begin
    eResultat.Text:='';  //on efface le résultat
    end;

    //Quand on fait un changement dans eMessage
    procedure TForm1.eMessageChange(Sender: TObject);
    var verif : string;
    begin
    eResultat.Text:='';  //on efface le résultat
    end;

    //Quand on clique sur le bouton 'crypter'
    procedure TForm1.bCrypterClick(Sender: TObject);
    var cle , chaineBloc, chaineBlocResultat : string[8];
    message, chaineFinale, varVerifMessage, varVerifCle : string;
    i, j, nbBloc, longeurCourteChaine : integer;
    begin
    //On vérifie tout d'abord si la clé et le message sont corrects
    varVerifCle:=verifCle(eCle.text);
    varVerifMessage:=verifMessage(eMessage.Text);
   if((varVerifCle<>'ok') or (varVerifMessage<>'ok') or (eCle.text='') or (eMessage.Text='')) then
            begin
    messagedlg('Le message doit contenir des caractères compris entre A et Z ainsi que l''espace.La clé doit contenir les chiffres de 1 à 8', mtWarning, [mbOk], 0);
    end
   else begin
    message := eMessage.Text;
    message := mettreEnMajuscule(message);
    eMessage.text:=message;
    cle := eCle.Text;
    chaineFinale:='';
    chaineBlocResultat:='00000000';
    //On remplace tous les espaces par des 0
      for i:=1 to length(message) do
    begin
         if (message[i]=' ') then
    message[i]:='0';
    end;

      if((length(message))mod 8<>0) then
    nbBloc:=trunc(length(message)/8)+1 //On regarde combien on a de bloc de 8char
            else
    nbBloc:=trunc(length(message)/8); //Si la longueur du message est multiple de 8

    //On parcourt les blocs un par un
      for i:=1 to nbBloc do
    begin
    chaineBloc:=copy(message,(i*8-7),8);
    //Si on a la derniere chaine avec moins de 8 char, on rajoute des '0' à la fin
         if (length(chaineBloc)<8) then
            begin
    longeurCourteChaine:=8-length(chaineBloc);
            for j:=1 to longeurCourteChaine do
    chaineBloc:=chaineBloc+'0';
    end;

    //On remplace les caractère par rapport à la clé
         for j:=1 to 8 do
    begin
    chaineBlocResultat[j]:=chaineBloc[strtoint(cle[j])];
    end;

    chaineFinale:=chaineFinale+chaineBlocResultat;  //On affect au résultat

    end;
    eResultat.Text:=chaineFinale; //Affichage du résultat
    end;
    end;

    procedure TForm1.bDecrypterClick(Sender: TObject);
    var cle , chaineBloc, chaineBlocResultat : string[8];
    message, chaineFinale, varVerifMessage, varVerifCle : string;
    i, j, nbBloc : integer;
    begin
    //On vérifie tout d'abord si la clé et le message sont corrects
    varVerifCle:=verifCle(eCle.text);
    varVerifMessage:=verifMessage(eMessage.Text);
   if((varVerifCle<>'ok') or (varVerifMessage<>'ok') or (eCle.text='') or (eMessage.Text='')) then
            begin
    messagedlg('Le message doit contenir des caractères compris entre A et Z ainsi que l''espace.La clé doit contenir les chiffres de 1 à 8', mtWarning, [mbOk], 0);
    end
   else begin
    message := eMessage.Text;
    message := mettreEnMajuscule(message);
    eMessage.text:=message;
    cle := eCle.Text;
    chaineFinale:='';
    chaineBlocResultat:='00000000';

    //Si on a pas une longueur de message multiple de 8, c'est qu'on a une erreur
      if((length(message))mod 8<>0) then
    messagedlg('Le message à décrypter est erroné', mtWarning, [mbOk],0)
      else begin
    nbBloc:=trunc(length(message)/8); //Si la longueur du message est multiple de 8

    //On parcourt les blocs un par un
         for i:=1 to nbBloc do
    begin
    chaineBloc:=copy(message,(i*8-7),8);

    //On remplace les caractère par rapport à la clé
            for j:=1 to 8 do
    begin
    chaineBlocResultat[strtoint(cle[j])]:=chaineBloc[j];
    end;

    chaineFinale:=chaineFinale+chaineBlocResultat;  //On affect au résultat

    end;
    //On remplace les 0 par des espaces :
         for i:=1 to length(chaineFinale) do
    begin
            if(chaineFinale[i]='0') then
    chaineFinale[i]:=' ';
    end;
    eResultat.Text:=chaineFinale; //Affichage du résultat
    end;
    end;
    end;

   **/



package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.generi.Genere;
import it.epicode.retro_vault.piattaforme.Piattaforma;
import it.epicode.retro_vault.piattaforme.PiattaformaRepository;
import it.epicode.retro_vault.recensioni.Recensione;
import it.epicode.retro_vault.recensioni.RecensioneRepository;
import it.epicode.retro_vault.utenti.Utente;
import it.epicode.retro_vault.utenti.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GiocoRunner implements CommandLineRunner {
    private final GiocoRepository giocoRepository;
    private final PiattaformaRepository piattaformaRepository;
    private final RecensioneRepository recensioneRepository;
    private final UtenteRepository utenteRepository;



    @Override
    public void run(String... args) throws Exception {

        Piattaforma piattaforma1 = new Piattaforma();
        piattaforma1.setNome("PlayStation 5");
        piattaforma1.setProduttore("Sony");
        piattaforma1.setAnnoUscita(2020);
        piattaforma1.setLogo("ps5_logo.png");
        piattaforma1 = piattaformaRepository.save(piattaforma1);

        Piattaforma piattaforma2 = new Piattaforma();
        piattaforma2.setNome("Xbox Series X");
        piattaforma2.setProduttore("Microsoft");
        piattaforma2.setAnnoUscita(2020);
        piattaforma2.setLogo("xbox_logo.png");
        piattaforma2 = piattaformaRepository.save(piattaforma2);


        Gioco gioco1 = new Gioco();
        gioco1.setTitolo("The Last of Us Part II");
        gioco1.setDescrizione("Un gioco di azione e avventura post-apocalittico.");
        gioco1.setAnnoUscita(2020);
        gioco1.setGenere(Genere.RPG);
        gioco1.setPiattaforma(piattaforma1);
        gioco1 = giocoRepository.save(gioco1);

        Gioco gioco2 = new Gioco();
        gioco2.setTitolo("Halo Infinite");
        gioco2.setDescrizione("Un gioco sparatutto in prima persona ambientato nell'universo di Halo.");
        gioco2.setAnnoUscita(2021);
        gioco2.setGenere(Genere.ADVENTURE);
        gioco2.setPiattaforma(piattaforma2);
        gioco2 = giocoRepository.save(gioco2);

        Utente utente1 = new Utente();
        utente1.setUsername("Marco Rossi");
        utente1.setEmail("marco.rossi@example.com");
        utente1.setPassword("password123");
        utente1 = utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("Anna Bianchi");
        utente2.setEmail("anna.bianchi@example.com");
        utente2.setPassword("password456");
        utente2 = utenteRepository.save(utente2);

        Utente utente3 = new Utente();
        utente3.setUsername("Giuseppe Verdi");
        utente3.setEmail("giuseppe.verdi@example.com");
        utente3.setPassword("password789");
        utente3 = utenteRepository.save(utente3);


        Recensione recensione1 = new Recensione();
        recensione1.setGioco(gioco1);
        recensione1.setCommento("Un'esperienza emozionante e coinvolgente!");
        recensione1.setVoto(9);
        recensione1.setDataRecensione(LocalDateTime.now());
        recensione1.setUtente(utente1);
        recensioneRepository.save(recensione1);

        Recensione recensione2 = new Recensione();
        recensione2.setGioco(gioco2);
        recensione2.setCommento("Un grande ritorno di Halo, ma con qualche difetto.");
        recensione2.setVoto(8);
        recensione2.setDataRecensione(LocalDateTime.now());
        recensione2.setUtente(utente2);
        recensioneRepository.save(recensione2);



    }
}

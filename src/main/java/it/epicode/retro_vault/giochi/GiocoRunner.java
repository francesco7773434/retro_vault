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
        piattaforma1.setNome("NES");
        piattaforma1.setProduttore("Nintendo");
        piattaforma1.setAnnoUscita(1983);
        piattaforma1.setLogo("nes_logo.png");
        piattaformaRepository.save(piattaforma1);

        Piattaforma piattaforma2 = new Piattaforma();
        piattaforma2.setNome("Super Nintendo Entertainment System");
        piattaforma2.setProduttore("Nintendo");
        piattaforma2.setAnnoUscita(1990);
        piattaforma2.setLogo("snes_logo.png");
        piattaformaRepository.save(piattaforma2);

        Piattaforma piattaforma3 = new Piattaforma();
        piattaforma3.setNome("Sega Genesis");
        piattaforma3.setProduttore("Sega");
        piattaforma3.setAnnoUscita(1988);
        piattaforma3.setLogo("genesis_logo.png");
        piattaformaRepository.save(piattaforma3);

        Piattaforma piattaforma4 = new Piattaforma();
        piattaforma4.setNome("Nintendo 64");
        piattaforma4.setProduttore("Nintendo");
        piattaforma4.setAnnoUscita(1996);
        piattaforma4.setLogo("n64_logo.png");
        piattaformaRepository.save(piattaforma4);

        Piattaforma piattaforma5 = new Piattaforma();
        piattaforma5.setNome("PlayStation");
        piattaforma5.setProduttore("Sony");
        piattaforma5.setAnnoUscita(1994);
        piattaforma5.setLogo("ps1_logo.png");
        piattaformaRepository.save(piattaforma5);

        Piattaforma piattaforma6 = new Piattaforma();
        piattaforma6.setNome("Game Boy");
        piattaforma6.setProduttore("Nintendo");
        piattaforma6.setAnnoUscita(1989);
        piattaforma6.setLogo("gameboy_logo.png");
        piattaformaRepository.save(piattaforma6);

        Piattaforma piattaforma7 = new Piattaforma();
        piattaforma7.setNome("Atari 2600");
        piattaforma7.setProduttore("Atari");
        piattaforma7.setAnnoUscita(1977);
        piattaforma7.setLogo("atari2600_logo.png");
        piattaformaRepository.save(piattaforma7);

        Piattaforma piattaforma8 = new Piattaforma();
        piattaforma8.setNome("Dreamcast");
        piattaforma8.setProduttore("Sega");
        piattaforma8.setAnnoUscita(1998);
        piattaforma8.setLogo("dreamcast_logo.png");
        piattaformaRepository.save(piattaforma8);

        Piattaforma piattaforma9 = new Piattaforma();
        piattaforma9.setNome("PlayStation 2");
        piattaforma9.setProduttore("Sony");
        piattaforma9.setAnnoUscita(2000);
        piattaforma9.setLogo("ps2_logo.png");
        piattaformaRepository.save(piattaforma9);

        Piattaforma piattaforma10 = new Piattaforma();
        piattaforma10.setNome("GameCube");
        piattaforma10.setProduttore("Nintendo");
        piattaforma10.setAnnoUscita(2001);
        piattaforma10.setLogo("gamecube_logo.png");
        piattaformaRepository.save(piattaforma10);

        Piattaforma piattaforma11 = new Piattaforma();
        piattaforma11.setNome("Sega Saturn");
        piattaforma11.setProduttore("Sega");
        piattaforma11.setAnnoUscita(1994);
        piattaforma11.setLogo("saturn_logo.png");
        piattaformaRepository.save(piattaforma11);

        Piattaforma piattaforma12 = new Piattaforma();
        piattaforma12.setNome("Neo Geo");
        piattaforma12.setProduttore("SNK");
        piattaforma12.setAnnoUscita(1990);
        piattaforma12.setLogo("neogeo_logo.png");
        piattaformaRepository.save(piattaforma12);


        Gioco gioco1 = new Gioco();
        gioco1.setTitolo("Pac-Man");
        gioco1.setDescrizione("Un classico arcade con un labirinto pieno di fantasmi.");
        gioco1.setAnnoUscita(1980);
        gioco1.setGenere(Genere.ARCADE);
        gioco1.setImmagine("https://upload.wikimedia.org/wikipedia/en/5/59/Pac-man.png");
        gioco1.setPiattaforma(piattaforma1); // NES
        giocoRepository.save(gioco1);

        Gioco gioco2 = new Gioco();
        gioco2.setTitolo("Space Invaders");
        gioco2.setDescrizione("Spara agli alieni prima che ti invadano!");
        gioco2.setAnnoUscita(1978);
        gioco2.setGenere(Genere.SHOOTER);
        gioco2.setImmagine("https://upload.wikimedia.org/wikipedia/en/4/4b/SpaceInvaders-ArcadeGame.png");
        gioco2.setPiattaforma(piattaforma1);
        giocoRepository.save(gioco2);

        Gioco gioco3 = new Gioco();
        gioco3.setTitolo("Tetris");
        gioco3.setDescrizione("Il puzzle game più iconico di tutti i tempi.");
        gioco3.setAnnoUscita(1984);
        gioco3.setGenere(Genere.PUZZLE);
        gioco3.setImmagine("https://upload.wikimedia.org/wikipedia/en/7/7c/TetrisBoxshotNES.jpg");
        gioco3.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco3);

        Gioco gioco4 = new Gioco();
        gioco4.setTitolo("Final Fantasy VI");
        gioco4.setDescrizione("Un viaggio RPG epico su SNES.");
        gioco4.setAnnoUscita(1994);
        gioco4.setGenere(Genere.RPG);
        gioco4.setImmagine("https://upload.wikimedia.org/wikipedia/en/b/bc/Final_Fantasy_VI_Box.jpg");
        gioco4.setPiattaforma(piattaforma2);
        giocoRepository.save(gioco4);

        Gioco gioco5 = new Gioco();
        gioco5.setTitolo("The Legend of Zelda: Ocarina of Time");
        gioco5.setDescrizione("Un'avventura senza tempo con Link.");
        gioco5.setAnnoUscita(1998);
        gioco5.setGenere(Genere.ADVENTURE);
        gioco5.setImmagine("https://upload.wikimedia.org/wikipedia/en/5/57/The_Legend_of_Zelda_Ocarina_of_Time.jpg");
        gioco5.setPiattaforma(piattaforma4); // N64
        giocoRepository.save(gioco5);

        Gioco gioco6 = new Gioco();
        gioco6.setTitolo("Street Fighter II");
        gioco6.setDescrizione("Il re dei picchiaduro classici.");
        gioco6.setAnnoUscita(1991);
        gioco6.setGenere(Genere.FIGHTING);
        gioco6.setImmagine("https://upload.wikimedia.org/wikipedia/en/0/05/Street_Fighter_II.jpg");
        gioco6.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco6);

        Gioco gioco7 = new Gioco();
        gioco7.setTitolo("F-Zero");
        gioco7.setDescrizione("Corse futuristiche ad alta velocità.");
        gioco7.setAnnoUscita(1990);
        gioco7.setGenere(Genere.RACING);
        gioco7.setImmagine("https://upload.wikimedia.org/wikipedia/en/f/fb/F-Zero_box.jpg");
        gioco7.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco7);

        Gioco gioco8 = new Gioco();
        gioco8.setTitolo("Tecmo Bowl");
        gioco8.setDescrizione("Il primo gioco sportivo di football americano.");
        gioco8.setAnnoUscita(1987);
        gioco8.setGenere(Genere.SPORTS);
        gioco8.setImmagine("https://upload.wikimedia.org/wikipedia/en/f/f6/Tecmo_Bowl_Coverart.png");
        gioco8.setPiattaforma(piattaforma1); // NES
        giocoRepository.save(gioco8);

        Gioco gioco9 = new Gioco();
        gioco9.setTitolo("Advance Wars");
        gioco9.setDescrizione("Strategia a turni con soldatini e carri armati.");
        gioco9.setAnnoUscita(2001);
        gioco9.setGenere(Genere.STRATEGY);
        gioco9.setImmagine("https://upload.wikimedia.org/wikipedia/en/f/f1/Advance_Wars_cover.png");
        gioco9.setPiattaforma(piattaforma6); // Game Boy Advance
        giocoRepository.save(gioco9);

        Gioco gioco10 = new Gioco();
        gioco10.setTitolo("The Sims");
        gioco10.setDescrizione("Vita simulata, in un mondo virtuale.");
        gioco10.setAnnoUscita(2000);
        gioco10.setGenere(Genere.SIMULATION);
        gioco10.setImmagine("https://upload.wikimedia.org/wikipedia/en/0/05/The_Sims_Original_Box_Art.png");
        gioco10.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco10);


        Gioco gioco11 = new Gioco();
        gioco11.setTitolo("Resident Evil");
        gioco11.setDescrizione("Sopravvivi all'incubo nella villa infestata.");
        gioco11.setAnnoUscita(1996);
        gioco11.setGenere(Genere.HORROR);
        gioco11.setImmagine("https://upload.wikimedia.org/wikipedia/en/b/b6/Resident_Evil_cover.png");
        gioco11.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco11);

        Gioco gioco12 = new Gioco();
        gioco12.setTitolo("Super Metroid");
        gioco12.setDescrizione("Esplora il pianeta Zebes in un classico metroidvania.");
        gioco12.setAnnoUscita(1994);
        gioco12.setGenere(Genere.METROIDVANIA);
        gioco12.setImmagine("https://upload.wikimedia.org/wikipedia/en/3/3e/Super_Metroid_boxart.png");
        gioco12.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco12);

        Gioco gioco13 = new Gioco();
        gioco13.setTitolo("Final Fight");
        gioco13.setDescrizione("Un picchiaduro a scorrimento tra i più iconici.");
        gioco13.setAnnoUscita(1989);
        gioco13.setGenere(Genere.BEAT_EM_UP);
        gioco13.setImmagine("https://upload.wikimedia.org/wikipedia/en/d/d3/Final_Fight_Coverart.png");
        gioco13.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco13);

        Gioco gioco14 = new Gioco();
        gioco14.setTitolo("Metal Gear Solid");
        gioco14.setDescrizione("Un classico del genere stealth con Solid Snake.");
        gioco14.setAnnoUscita(1998);
        gioco14.setGenere(Genere.STEALTH);
        gioco14.setImmagine("https://upload.wikimedia.org/wikipedia/en/3/33/Metal_Gear_Solid_cover_art.png");
        gioco14.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco14);

        Gioco gioco15 = new Gioco();
        gioco15.setTitolo("Clock Tower");
        gioco15.setDescrizione("Un survival horror punta e clicca unico.");
        gioco15.setAnnoUscita(1995);
        gioco15.setGenere(Genere.SURVIVAL);
        gioco15.setImmagine("https://upload.wikimedia.org/wikipedia/en/4/4d/Clock_Tower_cover.jpg");
        gioco15.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco15);

        Gioco gioco16 = new Gioco();
        gioco16.setTitolo("Monkey Island 2: LeChuck's Revenge");
        gioco16.setDescrizione("Una delle migliori avventure punta e clicca della LucasArts.");
        gioco16.setAnnoUscita(1991);
        gioco16.setGenere(Genere.POINT_AND_CLICK);
        gioco16.setImmagine("https://upload.wikimedia.org/wikipedia/en/7/7e/Monkey_Island_2_artwork.jpg");
        gioco16.setPiattaforma(piattaforma7); // Amiga
        giocoRepository.save(gioco16);

        Gioco gioco17 = new Gioco();
        gioco17.setTitolo("Diablo");
        gioco17.setDescrizione("Un dungeon crawler pieno d'azione e oscurità.");
        gioco17.setAnnoUscita(1996);
        gioco17.setGenere(Genere.HACK_AND_SLASH);
        gioco17.setImmagine("https://upload.wikimedia.org/wikipedia/en/1/10/Diablo_Coverart.png");
        gioco17.setPiattaforma(piattaforma7); // PC retro (assimilato)
        giocoRepository.save(gioco17);

        Gioco gioco18 = new Gioco();
        gioco18.setTitolo("Contra");
        gioco18.setDescrizione("Un action run-and-gun esplosivo.");
        gioco18.setAnnoUscita(1987);
        gioco18.setGenere(Genere.SHOOTER);
        gioco18.setImmagine("https://upload.wikimedia.org/wikipedia/en/0/09/Contra_cover.jpg");
        gioco18.setPiattaforma(piattaforma1); // NES
        giocoRepository.save(gioco18);

        Gioco gioco19 = new Gioco();
        gioco19.setTitolo("Castlevania: Symphony of the Night");
        gioco19.setDescrizione("Una pietra miliare del genere metroidvania.");
        gioco19.setAnnoUscita(1997);
        gioco19.setGenere(Genere.METROIDVANIA);
        gioco19.setImmagine("https://upload.wikimedia.org/wikipedia/en/2/24/Castlevania_SOTN_PAL.jpg");
        gioco19.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco19);

        Gioco gioco20 = new Gioco();
        gioco20.setTitolo("Gran Turismo");
        gioco20.setDescrizione("Simulazione automobilistica rivoluzionaria.");
        gioco20.setAnnoUscita(1997);
        gioco20.setGenere(Genere.SIMULATION);
        gioco20.setImmagine("https://upload.wikimedia.org/wikipedia/en/8/87/Gran_Turismo_Box_Art.jpg");
        gioco20.setPiattaforma(piattaforma5); // PlayStation
        giocoRepository.save(gioco20);

        Gioco gioco21 = new Gioco();
        gioco21.setTitolo("Street Fighter II");
        gioco21.setDescrizione("Il picchiaduro che ha definito un'epoca.");
        gioco21.setAnnoUscita(1991);
        gioco21.setGenere(Genere.FIGHTING);
        gioco21.setImmagine("https://upload.wikimedia.org/wikipedia/en/5/5e/SF2_JPN_Box.jpg");
        gioco21.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco21);

        Gioco gioco22 = new Gioco();
        gioco22.setTitolo("Sensible Soccer");
        gioco22.setDescrizione("Il calcio arcade per eccellenza degli anni '90.");
        gioco22.setAnnoUscita(1992);
        gioco22.setGenere(Genere.SPORTS);
        gioco22.setImmagine("https://upload.wikimedia.org/wikipedia/en/8/87/Sensible_Soccer_cover_art.jpg");
        gioco22.setPiattaforma(piattaforma7); // Amiga
        giocoRepository.save(gioco22);

        Gioco gioco23 = new Gioco();
        gioco23.setTitolo("Tetris");
        gioco23.setDescrizione("Il rompicapo più famoso della storia.");
        gioco23.setAnnoUscita(1984);
        gioco23.setGenere(Genere.PUZZLE);
        gioco23.setImmagine("https://upload.wikimedia.org/wikipedia/en/7/7c/Tetris_Boxshot.jpg");
        gioco23.setPiattaforma(piattaforma3); // Game Boy
        giocoRepository.save(gioco23);

        Gioco gioco24 = new Gioco();
        gioco24.setTitolo("Out Run");
        gioco24.setDescrizione("Un'icona dei giochi di corsa arcade.");
        gioco24.setAnnoUscita(1986);
        gioco24.setGenere(Genere.RACING);
        gioco24.setImmagine("https://upload.wikimedia.org/wikipedia/en/f/fc/Out_Run_Artwork.jpg");
        gioco24.setPiattaforma(piattaforma4); // Sega Mega Drive
        giocoRepository.save(gioco24);

        Gioco gioco25 = new Gioco();
        gioco25.setTitolo("Age of Empires");
        gioco25.setDescrizione("Strategia in tempo reale nell'antichità.");
        gioco25.setAnnoUscita(1997);
        gioco25.setGenere(Genere.STRATEGY);
        gioco25.setImmagine("https://upload.wikimedia.org/wikipedia/en/2/24/Age_of_Empires_1_cover.png");
        gioco25.setPiattaforma(piattaforma7); // PC/Amiga retro
        giocoRepository.save(gioco25);

        Gioco gioco26 = new Gioco();
        gioco26.setTitolo("Chrono Trigger");
        gioco26.setDescrizione("Un GDR leggendario con viaggi nel tempo.");
        gioco26.setAnnoUscita(1995);
        gioco26.setGenere(Genere.RPG);
        gioco26.setImmagine("https://upload.wikimedia.org/wikipedia/en/3/3e/Chrono_Trigger.jpg");
        gioco26.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco26);

        Gioco gioco27 = new Gioco();
        gioco27.setTitolo("Donkey Kong Country");
        gioco27.setDescrizione("Una rivoluzione visiva nel mondo platform.");
        gioco27.setAnnoUscita(1994);
        gioco27.setGenere(Genere.ADVENTURE);
        gioco27.setImmagine("https://upload.wikimedia.org/wikipedia/en/2/22/Donkey_Kong_Country_SNES_boxart.jpg");
        gioco27.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco27);

        Gioco gioco28 = new Gioco();
        gioco28.setTitolo("Prince of Persia");
        gioco28.setDescrizione("Salti, trappole e spade in una fortezza persiana.");
        gioco28.setAnnoUscita(1989);
        gioco28.setGenere(Genere.ADVENTURE); // se non hai PLATFORM puoi mapparlo su ADVENTURE
        gioco28.setImmagine("https://upload.wikimedia.org/wikipedia/en/2/2f/PrinceOfPersiaBoxArt1989.jpg");
        gioco28.setPiattaforma(piattaforma7); // Amiga
        giocoRepository.save(gioco28);

        Gioco gioco29 = new Gioco();
        gioco29.setTitolo("Paperboy");
        gioco29.setDescrizione("Consegna i giornali evitando ostacoli e caos urbano.");
        gioco29.setAnnoUscita(1985);
        gioco29.setGenere(Genere.SIMULATION);
        gioco29.setImmagine("https://upload.wikimedia.org/wikipedia/en/6/66/Paperboy_cover.jpg");
        gioco29.setPiattaforma(piattaforma1); // NES
        giocoRepository.save(gioco29);

        Gioco gioco30 = new Gioco();
        gioco30.setTitolo("EarthBound");
        gioco30.setDescrizione("Un RPG bizzarro, commovente e surreale.");
        gioco30.setAnnoUscita(1994);
        gioco30.setGenere(Genere.RPG);
        gioco30.setImmagine("https://upload.wikimedia.org/wikipedia/en/0/02/EarthBound_Box.jpg");
        gioco30.setPiattaforma(piattaforma2); // SNES
        giocoRepository.save(gioco30);

        Utente utente1 = new Utente();
        utente1.setUsername("Marco Rossi");
        utente1.setEmail("marco.rossi@example.com");
        utente1.setPassword("password123");
        utente1.setAvatar("https://example.com/avatar.jpg");
        utente1.setNome("Marco");
        utente1.setCognome("Rossi");
        utente1 = utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("Anna Bianchi");
        utente2.setEmail("anna.bianchi@example.com");
        utente2.setPassword("password456");
        utente2.setAvatar("https://example.com/avatar.jpg");
        utente2.setNome("Anna");
        utente2.setCognome("Bianchi");
        utente2 = utenteRepository.save(utente2);

        Utente utente3 = new Utente();
        utente3.setUsername("Giuseppe Verdi");
        utente3.setEmail("giuseppe.verdi@example.com");
        utente3.setPassword("password789");
        utente3.setAvatar("https://example.com/avatar.jpg");
        utente3.setNome("Giuseppe");
        utente3.setCognome("Verdi");
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

        Recensione recensione3 = new Recensione();
        recensione3.setGioco(gioco1);
        recensione3.setCommento("Un gioco di azione e avventura post-apocalittico.");
        recensione3.setVoto(7);
        recensione3.setDataRecensione(LocalDateTime.now());
        recensione3.setUtente(utente3);
        recensioneRepository.save(recensione3);



    }
}

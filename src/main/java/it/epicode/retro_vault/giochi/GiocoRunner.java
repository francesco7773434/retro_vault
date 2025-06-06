package it.epicode.retro_vault.giochi;

import it.epicode.retro_vault.auth.Role;
import it.epicode.retro_vault.generi.Genere;
import it.epicode.retro_vault.piattaforme.Piattaforma;
import it.epicode.retro_vault.piattaforme.PiattaformaRepository;
import it.epicode.retro_vault.recensioni.Recensione;
import it.epicode.retro_vault.recensioni.RecensioneRepository;
import it.epicode.retro_vault.utenti.Utente;
import it.epicode.retro_vault.utenti.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class GiocoRunner implements CommandLineRunner {
    private final GiocoRepository giocoRepository;
    private final PiattaformaRepository piattaformaRepository;
    private final RecensioneRepository recensioneRepository;
    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${retro-vault.init-data:false}")
    private boolean initData;


    private void salvaGiocoSeNonEsiste(String titolo, String descrizione, int anno,
                                       Genere genere, String immagine, Piattaforma piattaforma,String videoGameplay) {
        boolean giocoEsistente = giocoRepository.existsByTitolo(titolo);
        if (!giocoEsistente) {
            Gioco gioco = new Gioco();
            gioco.setTitolo(titolo);
            gioco.setDescrizione(descrizione);
            gioco.setAnnoUscita(anno);
            gioco.setGenere(genere);
            gioco.setImmagine(immagine);
            gioco.setPiattaforma(piattaforma);
            gioco.setVideoGameplay(videoGameplay);
            giocoRepository.save(gioco);
            System.out.println("Gioco salvato: " + titolo);  // Log per debug
        } else {
            System.out.println("Gioco già esistente: " + titolo);  // Log per debug
        }
    }

    private void creaUtenteSeNonEsiste(String username, String email, String password, String nome,
                                       String cognome, String avatar, Set<Role> roles) {
        if (utenteRepository.findByUsername(username).isEmpty()) {
            Utente utente = new Utente();
            utente.setUsername(username);
            utente.setEmail(email);
            utente.setPassword(passwordEncoder.encode(password));
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setAvatar(avatar);
            utente.setRoles(roles);
            utenteRepository.save(utente);
            System.out.println("Utente creato: " + username);
        } else {
            System.out.println("Utente già esistente: " + username);
        }
    }

    private Piattaforma creaPiattaformaSeNonEsiste(String nome, String produttore, int annoUscita, String logo) {
        return piattaformaRepository.findByNome(nome)
                .orElseGet(() -> {
                    Piattaforma piattaforma = new Piattaforma();
                    piattaforma.setNome(nome);
                    piattaforma.setProduttore(produttore);
                    piattaforma.setAnnoUscita(annoUscita);
                    piattaforma.setLogo(logo);
                    piattaformaRepository.save(piattaforma);
                    System.out.println("Piattaforma creata: " + nome);
                    return piattaforma;
                });
    }




    @Override
    public void run(String... args) throws Exception {

        if (!initData) {
            System.out.println("Inizializzazione dati disattivata (retro-vault.init-data=false).");
            return;
        }


        Piattaforma piattaforma1 = creaPiattaformaSeNonEsiste("NES", "Nintendo", 1983, "nes_logo.png");
        Piattaforma piattaforma2 = creaPiattaformaSeNonEsiste("Super Nintendo Entertainment System", "Nintendo", 1990, "snes_logo.png");
        Piattaforma piattaforma3 = creaPiattaformaSeNonEsiste("Sega Genesis", "Sega", 1988, "genesis_logo.png");
        Piattaforma piattaforma4 = creaPiattaformaSeNonEsiste("Nintendo 64", "Nintendo", 1996, "n64_logo.png");
        Piattaforma piattaforma5 = creaPiattaformaSeNonEsiste("PlayStation", "Sony", 1994, "ps1_logo.png");
        Piattaforma piattaforma6 = creaPiattaformaSeNonEsiste("Game Boy", "Nintendo", 1989, "gameboy_logo.png");
        Piattaforma piattaforma7 = creaPiattaformaSeNonEsiste("Atari 2600", "Atari", 1977, "atari2600_logo.png");
        Piattaforma piattaforma8 = creaPiattaformaSeNonEsiste("Dreamcast", "Sega", 1998, "dreamcast_logo.png");
        Piattaforma piattaforma9 = creaPiattaformaSeNonEsiste("PlayStation 2", "Sony", 2000, "ps2_logo.png");
        Piattaforma piattaforma10 = creaPiattaformaSeNonEsiste("GameCube", "Nintendo", 2001, "gamecube_logo.png");
        Piattaforma piattaforma11 = creaPiattaformaSeNonEsiste("Sega Saturn", "Sega", 1994, "saturn_logo.png");
        Piattaforma piattaforma12 = creaPiattaformaSeNonEsiste("Neo Geo", "SNK", 1990, "neogeo_logo.png");





        salvaGiocoSeNonEsiste("Pac-Man", "Un classico arcade con un labirinto pieno di fantasmi.", 1980, Genere.ARCADE, "https://www2.minijuegosgratis.com/v3/games/thumbnails/2399_1.jpg", piattaforma1, "https://www.youtube.com/watch?v=i_OjztdQ8iw");
        salvaGiocoSeNonEsiste("Space Invaders", "Spara agli alieni prima che ti invadano!", 1978, Genere.SHOOTER, "https://imgs.crazygames.com/games/space-invaders/cover_16x9-1714708168967.png?metadata=none&quality=40&width=1200&height=630&fit=crop", piattaforma1,"https://www.youtube.com/watch?v=MU4psw3ccUI");
        salvaGiocoSeNonEsiste("Tetris", "Il puzzle game più iconico di tutti i tempi.", 1984, Genere.PUZZLE, "https://m.media-amazon.com/images/I/61M3rDwh4qL._h1_.png", piattaforma2,"https://www.youtube.com/watch?v=-FAzHyXZPm0&t=21s");
        salvaGiocoSeNonEsiste("Final Fantasy VI", "Un viaggio RPG epico su SNES.", 1994, Genere.RPG, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_switch_download_software_1/2x1_NSwitchDS_FinalFantasyVI_image1600w.jpg", piattaforma2,"https://www.youtube.com/watch?v=EiIBeKCB7Eg");
        salvaGiocoSeNonEsiste("The Legend of Zelda: Ocarina of Time", "Un'avventura senza tempo con Link.", 1998, Genere.ADVENTURE, "https://pc-gaming.it/wp-content/uploads/2022/03/zelda-ocarina-of-time-open-download.jpg", piattaforma4,"https://www.youtube.com/watch?v=_iGC2zdPz8U");
        salvaGiocoSeNonEsiste("Street Fighter II", "Il re dei picchiaduro classici.", 1991, Genere.FIGHTING, "https://www.retrogaminghistory.com/filedata/fetch?type=large&id=279413", piattaforma2,"https://www.youtube.com/watch?v=xI284D4y1q4");
        salvaGiocoSeNonEsiste("F-Zero", "Corse futuristiche ad alta velocità.", 1990, Genere.RACING, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_FZero.jpg", piattaforma2,"https://www.youtube.com/watch?v=OF1SpvKRMD0");
        salvaGiocoSeNonEsiste("Tecmo Bowl", "Il primo gioco sportivo di football americano.", 1987, Genere.SPORTS, "https://m.media-amazon.com/images/M/MV5BNzVhZDk2YzgtNWY5Ny00YWQzLWEwMjctMzhjNmIyZjdjYThkXkEyXkFqcGdeQVRoaXJkUGFydHlJbmdlc3Rpb25Xb3JrZmxvdw@@._V1_.jpg", piattaforma1,"https://www.youtube.com/watch?v=JwAtZpcfXHk");
        salvaGiocoSeNonEsiste("Advance Wars", "Strategia a turni con soldatini e carri armati.", 2001, Genere.STRATEGY, "https://upload.wikimedia.org/wikipedia/it/1/14/GBA_Advance_Wars.png", piattaforma6,"https://www.youtube.com/watch?v=aFctAym0zb8");
        salvaGiocoSeNonEsiste("The Sims", "Vita simulata, in un mondo virtuale.", 2000, Genere.SIMULATION, "https://gaming-cdn.com/images/news/articles/10415/cover/1000x563/the-sims-e-the-sims-2-tornano-su-pc-il-31-gennaio-cover679a1075c7bc6.jpg", piattaforma5,"https://www.youtube.com/watch?v=AXfLzOK1RYs");
        salvaGiocoSeNonEsiste("Resident Evil", "Sopravvivi all'incubo nella villa infestata.", 1996, Genere.HORROR, "https://images.everyeye.it/img-notizie/resident-evil-9-quando-presentato-quando-uscirA-insider-non-dubbi-v5-800424-1200x1200.webp", piattaforma5,"https://www.youtube.com/watch?v=JEXQM7eyudc");
        salvaGiocoSeNonEsiste("Super Metroid", "Esplora il pianeta Zebes in un classico metroidvania.", 1994, Genere.METROIDVANIA, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_SuperMetroid_image1280w.jpg", piattaforma2,"https://www.youtube.com/watch?v=86Z4bwdxn_Y");
        salvaGiocoSeNonEsiste("Final Fight", "Un picchiaduro a scorrimento tra i più iconici.", 1989, Genere.BEAT_EM_UP, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/virtual_console_wii_u_7/SI_WiiUVC_FinalFight2_image1600w.jpg", piattaforma2,"https://www.youtube.com/watch?v=SUIxnUCN1NE");
        salvaGiocoSeNonEsiste("Metal Gear Solid", "Un classico del genere stealth con Solid Snake.", 1998, Genere.STEALTH, "https://generacionxbox.com/wp-content/uploads/2023/06/metal-gear-solid-1-generacion-xbox.jpg", piattaforma5,"https://www.youtube.com/watch?v=_zrvEmP41-s");
        salvaGiocoSeNonEsiste("Clock Tower", "Un survival horror punta e clicca unico.", 1995, Genere.SURVIVAL, "https://www.nintendo.com/eu/media/images/assets/nintendo_switch_games/clocktowerrewind/2x1_ClockTowerRewind_image1600w.jpg", piattaforma5,"https://www.youtube.com/watch?v=foXTsDKvRgc");
        salvaGiocoSeNonEsiste("Monkey Island 2: LeChuck's Revenge", "Una delle migliori avventure punta e clicca della LucasArts.", 1991, Genere.POINT_AND_CLICK, "https://shared.cloudflare.steamstatic.com/store_item_assets/steam/apps/32460/header.jpg?t=1741809770", piattaforma7,"https://www.youtube.com/watch?v=Dv-CL640hwE");
        salvaGiocoSeNonEsiste("Diablo", "Un dungeon crawler pieno d'azione e oscurità.", 1996, Genere.HACK_AND_SLASH, "https://image.api.playstation.com/vulcan/ap/rnd/202105/3117/9dbHmg4NNVdSKxyuVDU9N7kz.png", piattaforma7,"https://www.youtube.com/watch?v=2RAgr3uhdmg");
        salvaGiocoSeNonEsiste("Contra", "Un action run-and-gun esplosivo.", 1987, Genere.SHOOTER, "https://www.konami.com/products_master/eu_publish/contra_og/eu/it/images/galuga-1920x1080c.jpg", piattaforma1,"https://www.youtube.com/watch?v=2mWZlNOzdv8");
        salvaGiocoSeNonEsiste("Castlevania: Symphony of the Night", "Una pietra miliare del genere metroidvania.", 1997, Genere.METROIDVANIA, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZhYObb2-1zXq4-Srccd9ma7t1E7D-OTkD5g&s", piattaforma5,"https://www.youtube.com/watch?v=mOTUVXrAOE8");
        salvaGiocoSeNonEsiste("Gran Turismo", "Simulazione automobilistica rivoluzionaria.", 1997, Genere.SIMULATION, "https://i.ebayimg.com/images/g/Yg0AAOSwRqhmIkMB/s-l400.png", piattaforma5,"https://www.youtube.com/watch?v=XqlFs3s2JNM");
        salvaGiocoSeNonEsiste("Silvia  e Il salto dell aiuola", "Silvia una guerriera coraggiosa che salta per il mondo.", 1991, Genere.FIGHTING, "https://sm.ign.com/t/ign_it/screenshot/default/gals-panic-top_4y16.1280.jpg", piattaforma2,"https://www.youtube.com/watch?v=2mWZlNOzdv8");
        salvaGiocoSeNonEsiste("Sensible Soccer", "Il calcio arcade per eccellenza degli anni '90.", 1992, Genere.SPORTS, "https://upload.wikimedia.org/wikipedia/it/9/94/Sensible_soccer.PNG", piattaforma7,"https://www.youtube.com/watch?v=ZUqHQnhavtY");
        salvaGiocoSeNonEsiste("Spyro The Dragon", "Un drago e le sue avventure", 1984, Genere.ADVENTURE, "https://image.api.playstation.com/cdn/EP0002/CUSA12085_00/SzdddrptQcyO3tU3O9ALDT77gpNUnRtP.png", piattaforma5,"https://www.youtube.com/watch?v=HmatxYZtTD0");
        salvaGiocoSeNonEsiste("Out Run", "Un'icona dei giochi di corsa arcade.", 1986, Genere.RACING, "https://upload.wikimedia.org/wikipedia/it/e/e3/Out_Run.png", piattaforma4,"https://www.youtube.com/watch?v=hMv0Pg1AxFc");
        salvaGiocoSeNonEsiste("Age of Empires", "Strategia in tempo reale nell'antichità.", 1997, Genere.STRATEGY, "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1017900/ss_12a7ccb12eecca44db51e3a61bb6232f4db40c52.1920x1080.jpg?t=1744752314", piattaforma7,"https://www.youtube.com/watch?v=gu0YQQvsHz8");
        salvaGiocoSeNonEsiste("Chrono Trigger", "Un GDR leggendario con viaggi nel tempo.", 1995, Genere.RPG, "https://preview.redd.it/vv140szwpn9e1.jpeg?auto=webp&s=b077bdfdca3a56b8ed8ca70a721f06f500d9078f", piattaforma2,"https://www.youtube.com/watch?v=J7hzHlIsjwY");
        salvaGiocoSeNonEsiste("Donkey Kong Country", "Una rivoluzione visiva nel mondo platform.", 1994, Genere.ADVENTURE, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_DonkeyKongCountry_image1280w.jpg", piattaforma2,"https://www.youtube.com/watch?v=qFhT2yP_3U4");
        salvaGiocoSeNonEsiste("Prince of Persia", "Salti, trappole e spade in una fortezza persiana.", 1989, Genere.ADVENTURE, "https://cdn.oneesports.vn/cdn-data/sites/4/2022/11/POP-Remake-thumb.jpg", piattaforma7,"https://www.youtube.com/watch?v=FGQmtlxllWY");
        salvaGiocoSeNonEsiste("Paperboy", "Consegna i giornali evitando ostacoli e caos urbano.", 1985, Genere.SIMULATION, "https://www.retroplace.com/pics/nes/packshots/2752--paperboy.png", piattaforma1,"https://www.youtube.com/watch?v=l6DEL9GY-VU");
        salvaGiocoSeNonEsiste("EarthBound", "Un RPG bizzarro, commovente e surreale.", 1994, Genere.RPG, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_EarthBound.jpg", piattaforma2,"https://www.youtube.com/watch?v=am3A3kQE2U8");
        salvaGiocoSeNonEsiste("Galaga", "Un classico sparatutto arcade spaziale.", 1981, Genere.ARCADE, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_switch_download_software_1/2x1_NSwitchDS_ArcadeArchivesGalaga_image1600w.jpg", piattaforma1,"https://www.youtube.com/watch?v=dvjapcHsqXY");
        salvaGiocoSeNonEsiste("Doom", "Sparatutto in prima persona ambientato su Marte infestato.", 1993, Genere.SHOOTER, "https://images.mweb.bethesda.net/_images/doom-the-dark-ages/doom-tda-premium-banner.webp?f=jpg&h=1030&w=1858&s=RUEHO3D3bUaIF88RAvCBhkU75xNd6nnDXHv5TaiDOAw", piattaforma2,"https://www.youtube.com/watch?v=8mEP4cflrd4");
        salvaGiocoSeNonEsiste("Portal", "Puzzle game con portali e meccaniche innovative.", 2007, Genere.PUZZLE, "https://data.xxlgamer.com/products/3638/oqjASpsnbLeDmY-medium.jpg", piattaforma5,"https://www.youtube.com/watch?v=90yDSsZsgfA");
        salvaGiocoSeNonEsiste("Skyrim", "Un vasto RPG open world tra draghi e magia.", 2011, Genere.RPG, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_TheElderScrollsVSkyrim.jpg", piattaforma5,"https://www.youtube.com/watch?v=eDh5TJcs7FU");
        salvaGiocoSeNonEsiste("Tomb Raider", "Un'avventura epica con Lara Croft.", 1996, Genere.ADVENTURE, "https://game-experience.it/wp-content/uploads/2025/04/la-serie-tv-di-tomb-raider-in-lavorazione-presso-amazon-prime-video-sta-riscontrando-dei-problemi.jpg", piattaforma4,"https://www.youtube.com/watch?v=I0r5pM-1Hgw");
        salvaGiocoSeNonEsiste("Mortal Kombat", "Il picchiaduro violento e iconico.", 1992, Genere.FIGHTING, "https://i.ytimg.com/vi/LjNA9f2zyn4/maxresdefault.jpg", piattaforma2,"https://www.youtube.com/watch?v=lW7r2w8SsN0");
        salvaGiocoSeNonEsiste("Mario Kart 64", "Corse frenetiche con i personaggi Nintendo.", 1996, Genere.RACING, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_7/H2x1_N64_MarioKart64.jpg", piattaforma4,"https://www.youtube.com/watch?v=w8K-heSWX8s");
        salvaGiocoSeNonEsiste("FIFA 21", "Il calcio simulato con licenze ufficiali.", 2020, Genere.SPORTS, "https://www.internetmatters.org/wp-content/uploads/2024/08/FIFA-2021-image-1200-630.png", piattaforma6,"https://www.youtube.com/watch?v=QJJX0vXDP4g");
        salvaGiocoSeNonEsiste("StarCraft", "Strategia in tempo reale tra razze aliene.", 1998, Genere.STRATEGY, "https://blz-contentstack-images.akamaized.net/v3/assets/blt0e00eb71333df64e/blt792ae823e2d6d0df/6580e3079ac620722d04b35a/media_gallery_6.webp", piattaforma7,"https://www.youtube.com/watch?v=Eg-jIWWemeQ");
        salvaGiocoSeNonEsiste("The Sims 4", "Simulazione di vita quotidiana e personalizzazione.", 2014, Genere.SIMULATION, "https://m.media-amazon.com/images/I/8187vWf7WtL._AC_UF1000,1000_QL80_.jpg", piattaforma5,"https://www.youtube.com/watch?v=2BUHtqroKRw");


        creaUtenteSeNonEsiste("Marco Rossi", "marco.rossi@example.com", "password123", "Marco", "Rossi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("Anna Bianchi", "anna.bianchi@example.com", "password456", "Anna", "Bianchi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("Giuseppe Verdi", "giuseppe.verdi@example.com", "password789", "Giuseppe", "Verdi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("lucaconti", "luca.conti@example.com", "pass1234", "Luca", "Conti", "https://example.com/avatar4.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("giuliarinaldi", "giulia.rinaldi@example.com", "pass5678", "Giulia", "Rinaldi", "https://example.com/avatar5.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("marcobianchi", "marco.bianchi@example.com", "pwd7890", "Marco", "Bianchi", "https://example.com/avatar6.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("saraferrari", "sara.ferrari@example.com", "pwd12345", "Sara", "Ferrari", "https://example.com/avatar7.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("daviderusso", "davide.russo@example.com", "pwd67890", "Davide", "Russo", "https://example.com/avatar8.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("francescamoretti", "francesca.moretti@example.com", "mypassword", "Francesca", "Moretti", "https://example.com/avatar9.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("alessandrolombardi", "alessandro.lombardi@example.com", "passpass", "Alessandro", "Lombardi", "https://example.com/avatar10.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("elenamartini", "elena.martini@example.com", "password1", "Elena", "Martini", "https://example.com/avatar11.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("matteogreco", "matteo.greco@example.com", "password2", "Matteo", "Greco", "https://example.com/avatar12.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("chiaraserra", "chiara.serra@example.com", "password3", "Chiara", "Serra", "https://example.com/avatar13.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("andreacosta", "andrea.costa@example.com", "password4", "Andrea", "Costa", "https://example.com/avatar14.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("valentinafontana", "valentina.fontana@example.com", "password5", "Valentina", "Fontana", "https://example.com/avatar15.jpg", Set.of(Role.ROLE_USER));


        creaUtenteSeNonEsiste("admin", "admin@example.com", "password", "Admin", "Admin", "https://example.com/avatar.jpg", Set.of(Role.ROLE_ADMIN));

        if (utenteRepository.findByUsername("admin").isEmpty()) {
            Utente admin = new Utente();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setAvatar("https://example.com/avatar.jpg");
            admin.setNome("Admin");
            admin.setCognome("Admin");
            admin.setRoles(Set.of(Role.ROLE_ADMIN));
            utenteRepository.save(admin);

            System.out.println("Utente admin creato.");
        } else {
            System.out.println("Utente admin già presente.");
        }

        String[] commentiFake = {
                "Un gioco davvero divertente, lo consiglio a tutti!",
                "Grafica e gameplay perfetti per l’epoca.",
                "Mi ha fatto rivivere tantissimi ricordi.",
                "Un classico intramontabile che non delude mai.",
                "Ottima colonna sonora e sfida bilanciata.",
                "Peccato per qualche bug, ma nel complesso bello.",
                "La storia è coinvolgente e ben scritta.",
                "Un’esperienza di gioco unica e appassionante.",
                "Divertente e semplice da imparare, ma difficile da padroneggiare.",
                "Un must-have per gli amanti del genere!"
        };

        int commentIndex = 0;

        for (Utente utente : utenteRepository.findAll()) {
            for (Gioco gioco : giocoRepository.findAll()) {
                boolean recensioneEsistente = recensioneRepository.existsByUtenteAndGioco(utente, gioco);

                if (!recensioneEsistente) {
                    Recensione recensione = new Recensione();
                    recensione.setUtente(utente);
                    recensione.setGioco(gioco);
                    recensione.setDataRecensione(LocalDateTime.now());

                    // Assegna commento faker e voto random da 3 a 5
                    recensione.setCommento(commentiFake[commentIndex % commentiFake.length]);
                    recensione.setVoto(3 + (int)(Math.random() * 3)); // 3, 4 o 5

                    recensioneRepository.save(recensione);
                    commentIndex++;

                    System.out.println("Recensione creata per utente: " + utente.getUsername() + ", gioco: " + gioco.getTitolo());
                }
            }
        }
    }








    }


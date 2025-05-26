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

    private void salvaGiocoSeNonEsiste(String titolo, String descrizione, int anno,
                                       Genere genere, String immagine, Piattaforma piattaforma) {
        boolean giocoEsistente = giocoRepository.existsByTitolo(titolo);
        if (!giocoEsistente) {
            Gioco gioco = new Gioco();
            gioco.setTitolo(titolo);
            gioco.setDescrizione(descrizione);
            gioco.setAnnoUscita(anno);
            gioco.setGenere(genere);
            gioco.setImmagine(immagine);
            gioco.setPiattaforma(piattaforma);
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





        salvaGiocoSeNonEsiste("Pac-Man", "Un classico arcade con un labirinto pieno di fantasmi.", 1980, Genere.ARCADE, "https://www2.minijuegosgratis.com/v3/games/thumbnails/2399_1.jpg", piattaforma1);
        salvaGiocoSeNonEsiste("Space Invaders", "Spara agli alieni prima che ti invadano!", 1978, Genere.SHOOTER, "https://imgs.crazygames.com/games/space-invaders/cover_16x9-1714708168967.png?metadata=none&quality=40&width=1200&height=630&fit=crop", piattaforma1);
        salvaGiocoSeNonEsiste("Tetris", "Il puzzle game più iconico di tutti i tempi.", 1984, Genere.PUZZLE, "https://m.media-amazon.com/images/I/61M3rDwh4qL._h1_.png", piattaforma2);
        salvaGiocoSeNonEsiste("Final Fantasy VI", "Un viaggio RPG epico su SNES.", 1994, Genere.RPG, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_switch_download_software_1/2x1_NSwitchDS_FinalFantasyVI_image1600w.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("The Legend of Zelda: Ocarina of Time", "Un'avventura senza tempo con Link.", 1998, Genere.ADVENTURE, "https://pc-gaming.it/wp-content/uploads/2022/03/zelda-ocarina-of-time-open-download.jpg", piattaforma4);
        salvaGiocoSeNonEsiste("Street Fighter II", "Il re dei picchiaduro classici.", 1991, Genere.FIGHTING, "https://www.retrogaminghistory.com/filedata/fetch?type=large&id=279413", piattaforma2);
        salvaGiocoSeNonEsiste("F-Zero", "Corse futuristiche ad alta velocità.", 1990, Genere.RACING, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_FZero.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("Tecmo Bowl", "Il primo gioco sportivo di football americano.", 1987, Genere.SPORTS, "https://m.media-amazon.com/images/M/MV5BNzVhZDk2YzgtNWY5Ny00YWQzLWEwMjctMzhjNmIyZjdjYThkXkEyXkFqcGdeQVRoaXJkUGFydHlJbmdlc3Rpb25Xb3JrZmxvdw@@._V1_.jpg", piattaforma1);
        salvaGiocoSeNonEsiste("Advance Wars", "Strategia a turni con soldatini e carri armati.", 2001, Genere.STRATEGY, "https://upload.wikimedia.org/wikipedia/it/1/14/GBA_Advance_Wars.png", piattaforma6);
        salvaGiocoSeNonEsiste("The Sims", "Vita simulata, in un mondo virtuale.", 2000, Genere.SIMULATION, "https://gaming-cdn.com/images/news/articles/10415/cover/1000x563/the-sims-e-the-sims-2-tornano-su-pc-il-31-gennaio-cover679a1075c7bc6.jpg", piattaforma5);
        salvaGiocoSeNonEsiste("Resident Evil", "Sopravvivi all'incubo nella villa infestata.", 1996, Genere.HORROR, "https://images.everyeye.it/img-notizie/resident-evil-9-quando-presentato-quando-uscirA-insider-non-dubbi-v5-800424-1200x1200.webp", piattaforma5);
        salvaGiocoSeNonEsiste("Super Metroid", "Esplora il pianeta Zebes in un classico metroidvania.", 1994, Genere.METROIDVANIA, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_SuperMetroid_image1280w.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("Final Fight", "Un picchiaduro a scorrimento tra i più iconici.", 1989, Genere.BEAT_EM_UP, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/virtual_console_wii_u_7/SI_WiiUVC_FinalFight2_image1600w.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("Metal Gear Solid", "Un classico del genere stealth con Solid Snake.", 1998, Genere.STEALTH, "https://generacionxbox.com/wp-content/uploads/2023/06/metal-gear-solid-1-generacion-xbox.jpg", piattaforma5);
        salvaGiocoSeNonEsiste("Clock Tower", "Un survival horror punta e clicca unico.", 1995, Genere.SURVIVAL, "https://www.nintendo.com/eu/media/images/assets/nintendo_switch_games/clocktowerrewind/2x1_ClockTowerRewind_image1600w.jpg", piattaforma5);
        salvaGiocoSeNonEsiste("Monkey Island 2: LeChuck's Revenge", "Una delle migliori avventure punta e clicca della LucasArts.", 1991, Genere.POINT_AND_CLICK, "https://shared.cloudflare.steamstatic.com/store_item_assets/steam/apps/32460/header.jpg?t=1741809770", piattaforma7);
        salvaGiocoSeNonEsiste("Diablo", "Un dungeon crawler pieno d'azione e oscurità.", 1996, Genere.HACK_AND_SLASH, "https://image.api.playstation.com/vulcan/ap/rnd/202105/3117/9dbHmg4NNVdSKxyuVDU9N7kz.png", piattaforma7);
        salvaGiocoSeNonEsiste("Contra", "Un action run-and-gun esplosivo.", 1987, Genere.SHOOTER, "https://www.konami.com/products_master/eu_publish/contra_og/eu/it/images/galuga-1920x1080c.jpg", piattaforma1);
        salvaGiocoSeNonEsiste("Castlevania: Symphony of the Night", "Una pietra miliare del genere metroidvania.", 1997, Genere.METROIDVANIA, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZhYObb2-1zXq4-Srccd9ma7t1E7D-OTkD5g&s", piattaforma5);
        salvaGiocoSeNonEsiste("Gran Turismo", "Simulazione automobilistica rivoluzionaria.", 1997, Genere.SIMULATION, "https://i.ebayimg.com/images/g/Yg0AAOSwRqhmIkMB/s-l400.png", piattaforma5);
        salvaGiocoSeNonEsiste("Silvia  e Il salto dell aiuola", "Silvia una guerriera coraggiosa che salta per il mondo.", 1991, Genere.FIGHTING, "https://sm.ign.com/t/ign_it/screenshot/default/gals-panic-top_4y16.1280.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("Sensible Soccer", "Il calcio arcade per eccellenza degli anni '90.", 1992, Genere.SPORTS, "https://upload.wikimedia.org/wikipedia/it/9/94/Sensible_soccer.PNG", piattaforma7);
        salvaGiocoSeNonEsiste("Spyro The Dragon", "Un drago e le sue avventure", 1984, Genere.ADVENTURE, "https://image.api.playstation.com/cdn/EP0002/CUSA12085_00/SzdddrptQcyO3tU3O9ALDT77gpNUnRtP.png", piattaforma5);
        salvaGiocoSeNonEsiste("Out Run", "Un'icona dei giochi di corsa arcade.", 1986, Genere.RACING, "https://upload.wikimedia.org/wikipedia/it/e/e3/Out_Run.png", piattaforma4);
        salvaGiocoSeNonEsiste("Age of Empires", "Strategia in tempo reale nell'antichità.", 1997, Genere.STRATEGY, "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1017900/ss_12a7ccb12eecca44db51e3a61bb6232f4db40c52.1920x1080.jpg?t=1744752314", piattaforma7);
        salvaGiocoSeNonEsiste("Chrono Trigger", "Un GDR leggendario con viaggi nel tempo.", 1995, Genere.RPG, "https://preview.redd.it/vv140szwpn9e1.jpeg?auto=webp&s=b077bdfdca3a56b8ed8ca70a721f06f500d9078f", piattaforma2);
        salvaGiocoSeNonEsiste("Donkey Kong Country", "Una rivoluzione visiva nel mondo platform.", 1994, Genere.ADVENTURE, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_DonkeyKongCountry_image1280w.jpg", piattaforma2);
        salvaGiocoSeNonEsiste("Prince of Persia", "Salti, trappole e spade in una fortezza persiana.", 1989, Genere.ADVENTURE, "https://cdn.oneesports.vn/cdn-data/sites/4/2022/11/POP-Remake-thumb.jpg", piattaforma7);
        salvaGiocoSeNonEsiste("Paperboy", "Consegna i giornali evitando ostacoli e caos urbano.", 1985, Genere.SIMULATION, "https://www.retroplace.com/pics/nes/packshots/2752--paperboy.png", piattaforma1);
        salvaGiocoSeNonEsiste("EarthBound", "Un RPG bizzarro, commovente e surreale.", 1994, Genere.RPG, "https://www.nintendo.com/eu/media/images/10_share_images/games_15/super_nintendo_5/H2x1_SNES_EarthBound.jpg", piattaforma2);

        creaUtenteSeNonEsiste("Marco Rossi", "marco.rossi@example.com", "password123", "Marco", "Rossi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("Anna Bianchi", "anna.bianchi@example.com", "password456", "Anna", "Bianchi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));
        creaUtenteSeNonEsiste("Giuseppe Verdi", "giuseppe.verdi@example.com", "password789", "Giuseppe", "Verdi", "https://example.com/avatar.jpg", Set.of(Role.ROLE_USER));

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
    }






    }


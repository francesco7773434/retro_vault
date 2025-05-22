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

        Utente utente1 = new Utente();
        utente1.setUsername("Marco Rossi");
        utente1.setEmail("marco.rossi@example.com");
        utente1.setPassword("password123");
        utente1.setAvatar("https://example.com/avatar.jpg");
        utente1.setNome("Marco");
        utente1.setCognome("Rossi");
        utente1.setRoles(Set.of(Role.ROLE_USER));
        utente1 = utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("Anna Bianchi");
        utente2.setEmail("anna.bianchi@example.com");
        utente2.setPassword("password456");
        utente2.setAvatar("https://example.com/avatar.jpg");
        utente2.setNome("Anna");
        utente2.setCognome("Bianchi");
        utente2.setRoles(Set.of(Role.ROLE_USER));
        utente2 = utenteRepository.save(utente2);

        Utente utente3 = new Utente();
        utente3.setUsername("Giuseppe Verdi");
        utente3.setEmail("giuseppe.verdi@example.com");
        utente3.setPassword("password789");
        utente3.setAvatar("https://example.com/avatar.jpg");
        utente3.setNome("Giuseppe");
        utente3.setCognome("Verdi");
        utente3.setRoles(Set.of(Role.ROLE_USER));
        utente3 = utenteRepository.save(utente3);

        Utente admin = new Utente();
        admin.setUsername("admin");
        admin.setEmail("admin@example");
        admin.setPassword("password");
        admin.setAvatar("https://example.com/avatar.jpg");
        admin.setNome("Admin");
        admin.setCognome("Admin");
        admin.setRoles(Set.of(Role.ROLE_ADMIN, Role.ROLE_USER));
        admin = utenteRepository.save(admin);






    }
}

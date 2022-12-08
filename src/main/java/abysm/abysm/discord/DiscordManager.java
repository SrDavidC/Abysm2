package abysm.abysm.discord;

import abysm.abysm.Abysm;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.lang.System;


import javax.security.auth.login.LoginException;
import java.awt.*;
import java.time.LocalDate;

public class DiscordManager extends ListenerAdapter {

    public Abysm plugin;
    public JDA jda;
    final private String token = Abysm.getPl().getToken();
    private static DiscordManager discordManager;
    final private String anunciosChannel = "anuncios";
    final private String staffChannel = "staff";
    public String muertosChannel = "\uD83D\uDC80〈muertos";

    public DiscordManager(){
        this.plugin = Abysm.getPl();
        final JDABuilder builder = JDABuilder.createDefault(token);
        builder.setActivity(Activity.listening("Ultrawenik Abysm OST"));
        try {
            (this.jda = builder.build()).awaitReady();
        } catch (InterruptedException | LoginException e) {
            e.printStackTrace();
        }
        final TextChannel channel = this.jda.getTextChannelById("894814006714462252");
        EmbedBuilder bd = this.buildEmbed("Abysm", Color.GREEN, null, null, null, ":gear: Plugin encendido.");
        channel.sendMessageEmbeds(bd.build()).queue();

    }

    private EmbedBuilder buildEmbed(final String title, final Color color, final String footer, final String image, final String thumbnail, final String... description) {
        final EmbedBuilder eb = new EmbedBuilder();
        if (title != null) {
            eb.setTitle(title);
        }
        if (color != null) {
            eb.setColor(color);
        }
        if (footer != null) {
            eb.setFooter(footer);
        }
        if (image != null) {
            eb.setImage(image);
        }
        if (thumbnail != null) {
            eb.setThumbnail(thumbnail);
        }
        for (final String s : description) {
            eb.addField("", s, false);
        }
        return eb;
    }

    private void sendEmbed(final MessageChannel channel, final EmbedBuilder b, final String... reaction) {
        final int[] length = new int[1];
        final int[] i = {0};
        final String[] s = new String[1];
        channel.sendMessage((Message) b.build()).queue(message -> {
            for (length[0] = reaction.length; i[0] < length[0]; ++i[0]) {
                s[0] = reaction[i[0]];
                message.addReaction(s[0]).queue();
            }
        });
    }

    public void deathAnnounce(String nombre, String razon, String coords, boolean totem, int cantTotem){
        if (this.jda == null){ return; }
        final String serverName = "ABYSM";
        final LocalDate n = LocalDate.now();
        final String date = String.format("%02d/%02d/%02d", n.getDayOfMonth(), n.getMonthValue(), n.getYear());
        EmbedBuilder b = this.buildEmbed("\u00A1"+ nombre + " ha MUERTO en " + serverName + "!\n", new Color(138,43,226), null, null, "https://minotar.net/armor/bust/" + nombre + "/100.png", new String[0]);
        TextChannel channel = this.jda.getTextChannelById("927616458547142666");
        if (totem) {
            b = this.buildEmbed("\u00A1" + nombre + " ha usado un TOTEM! \n", new Color(138, 43, 226), null, null, "https://minotar.net/armor/bust/" + nombre + "/100.png", new String[0]);
            b.addField("\uD83C\uDFB2 N\u00FAmero de totem: #", String.valueOf(cantTotem), true);
            channel = this.jda.getTextChannelById("927778362938765342");
        }
        b.addField("\ud83d\udcc5 Fecha", date, true);
        b.addField("\ud83d\udc80 Raz\u00f3n", razon, true);
        b.addField("\ud83e\udded Coordenadas", coords, true);
        channel.sendMessageEmbeds(b.build()).queue();


    }
    public static DiscordManager getInstance() {
        if (DiscordManager.discordManager == null) {
            DiscordManager.discordManager = new DiscordManager();
        }
        return DiscordManager.discordManager;
    }
}







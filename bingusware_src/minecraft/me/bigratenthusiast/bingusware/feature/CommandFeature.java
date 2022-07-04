package me.bigratenthusiast.bingusware.feature;

import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Packet3Chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandFeature {
    public static String prefix = ".";
    public static String[] onAuthority = new String[] {
        "A number of Socialists have latterly launched a regular crusade against what they call the principle",
        " of authority. It suffices to tell them that this or that act is authoritarian for it to be condemne",
        "d. This summary mode of procedure is being abused to such an extent that it has become necessary to ",
        "look into the matter somewhat more closely. Authority, in the sense in which the word is used here, ",
        "means: the imposition of the will of another upon ours; on the other hand, authority presupposes sub",
        "ordination. Now, since these two words sound bad, and the relationship which they represent is disag",
        "reeable to the subordinated party, the question is to ascertain whether there is any way of dispensi",
        "ng with it, whether — given the conditions of present-day society — we could not create another soci",
        "al system, in which this authority would be given no scope any longer, and would consequently have t",
        "o disappear. On examining the economic, industrial and agricultural conditions which form the basis ",
        "of present-day bourgeois society, we find that they tend more and more to replace isolated action by",
        " combined action of individuals. Modern industry, with its big factories and mills, where hundreds o",
        "f workers supervise complicated machines driven by steam, has superseded the small workshops of the ",
        "separate producers; the carriages and wagons of the highways have become substituted by railway trai",
        "ns, just as the small schooners and sailing feluccas have been by steam-boats. Even agriculture fall",
        "s increasingly under the dominion of the machine and of steam, which slowly but relentlessly put in ",
        "the place of the small proprietors big capitalists, who with the aid of hired workers cultivate vast",
        " stretches of land. Everywhere combined action, the complication of processes dependent upon each ot",
        "her, displaces independent action by individuals. But whoever mentions combined action speaks of org",
        "anisation; now, is it possible to have organisation without authority? Supposing a social revolution",
        " dethroned the capitalists, who now exercise their authority over the production and circulation of ",
        "wealth. Supposing, to adopt entirely the point of view of the anti-authoritarians, that the land and",
        " the instruments of labour had become the collective property of the workers who use them. Will auth",
        "ority have disappeared, or will it only have changed its form? Let us see. Let us take by way if exa",
        "mple a cotton spinning mill. The cotton must pass through at least six successive operations before ",
        "it is reduced to the state of thread, and these operations take place for the most part in different",
        " rooms. Furthermore, keeping the machines going requires an engineer to look after the steam engine,",
        " mechanics to make the current repairs, and many other labourers whose business it is to transfer th",
        "e products from one room to another, and so forth. All these workers, men, women and children, are o",
        "bliged to begin and finish their work at the hours fixed by the authority of the steam, which cares ",
        "nothing for individual autonomy. The workers must, therefore, first come to an understanding on the ",
        "hours of work; and these hours, once they are fixed, must be observed by all, without any exception.",
        " Thereafter particular questions arise in each room and at every moment concerning the mode of produ",
        "ction, distribution of material, etc., which must be settled by decision of a delegate placed at the",
        " head of each branch of labour or, if possible, by a majority vote, the will of the single individua",
        "l will always have to subordinate itself, which means that questions are settled in an authoritarian",
        " way. The automatic machinery of the big factory is much more despotic than the small capitalists wh",
        "o employ workers ever have been. At least with regard to the hours of work one may write upon the po",
        "rtals of these factories: Lasciate ogni autonomia, voi che entrate! [Leave, ye that enter in, all au",
        "tonomy behind!] If man, by dint of his knowledge and inventive genius, has subdued the forces of nat",
        "ure, the latter avenge themselves upon him by subjecting him, in so far as he employs them, to a ver",
        "itable despotism independent of all social organisation. Wanting to abolish authority in large-scale",
        " industry is tantamount to wanting to abolish industry itself, to destroy the power loom in order to",
        " return to the spinning wheel. Let us take another example — the railway. Here too the co-operation ",
        "of an infinite number of individuals is absolutely necessary, and this co-operation must be practise",
        "d during precisely fixed hours so that no accidents may happen. Here, too, the first condition of th",
        "e job is a dominant will that settles all subordinate questions, whether this will is represented by",
        " a single delegate or a committee charged with the execution of the resolutions of the majority of p",
        "ersona interested. In either case there is a very pronounced authority. Moreover, what would happen ",
        "to the first train dispatched if the authority of the railway employees over the Hon. passengers wer",
        "e abolished? But the necessity of authority, and of imperious authority at that, will nowhere be fou",
        "nd more evident than on board a ship on the high seas. There, in time of danger, the lives of all de",
        "pend on the instantaneous and absolute obedience of all to the will of one. When I submitted argumen",
        "ts like these to the most rabid anti-authoritarians, the only answer they were able to give me was t",
        "he following: Yes, that's true, but there it is not the case of authority which we confer on our del",
        "egates, but of a commission entrusted! These gentlemen think that when they have changed the names o",
        "f things they have changed the things themselves. This is how these profound thinkers mock at the wh",
        "ole world. We have thus seen that, on the one hand, a certain authority, no matter how delegated, an",
        "d, on the other hand, a certain subordination, are things which, independently of all social organis",
        "ation, are imposed upon us together with the material conditions under which we produce and make pro",
        "ducts circulate. We have seen, besides, that the material conditions of production and circulation i",
        "nevitably develop with large-scale industry and large-scale agriculture, and increasingly tend to en",
        "large the scope of this authority. Hence it is absurd to speak of the principle of authority as bein",
        "g absolutely evil, and of the principle of autonomy as being absolutely good. Authority and autonomy",
        " are relative things whose spheres vary with the various phases of the development of society. If th",
        "e autonomists confined themselves to saying that the social organisation of the future would restric",
        "t authority solely to the limits within which the conditions of production render it inevitable, we ",
        "could understand each other; but they are blind to all facts that make the thing necessary and they ",
        "passionately fight the world. Why do the anti-authoritarians not confine themselves to crying out ag",
        "ainst political authority, the state? All Socialists are agreed that the political state, and with i",
        "t political authority, will disappear as a result of the coming social revolution, that is, that pub",
        "lic functions will lose their political character and will be transformed into the simple administra",
        "tive functions of watching over the true interests of society. But the anti-authoritarians demand th",
        "at the political state be abolished at one stroke, even before the social conditions that gave birth",
        " to it have been destroyed. They demand that the first act of the social revolution shall be the abo",
        "lition of authority. Have these gentlemen ever seen a revolution? A revolution is certainly the most",
        " authoritarian thing there is; it is the act whereby one part of the population imposes its will upo",
        "n the other part by means of rifles, bayonets and cannon — authoritarian means, if such there be at ",
        "all; and if the victorious party does not want to have fought in vain, it must maintain this rule by",
        " means of the terror which its arms inspire in the reactionists. Would the Paris Commune have lasted",
        " a single day if it had not made use of this authority of the armed people against the bourgeois? Sh",
        "ould we not, on the contrary, reproach it for not having used it freely enough? Therefore, either on",
        "e of two things: either the anti-authoritarians don't know what they're talking about, in which case",
        " they are creating nothing but confusion; or they do know, and in that case they are betraying the m",
        "ovement of the proletariat. In either case they serve the reaction."
    };

    public static boolean onEvent(Client.EventType type, Object... params) {
        if (type == Client.EventType.CHAT_EVENT) {
            String content = (String) params[0];
            if (content.startsWith(prefix)) {
                String command = content.substring(prefix.length()).split(" ")[0];
                List<String> _args = new ArrayList<String>(Arrays.asList(content.split(" ")));
                if (_args.size() > 0) _args.remove(0);
                String[] args = _args.toArray(new String[0]);
                onCommand(command, args);
                return false;
            }
        }
        return true;
    }

    public static void onCommand(String command, String[] args) {
        switch (command) {
            case "help":
                Client.hud.drawActionBar("\u00a7c nope :)");
                break;
            case "toggle":
                if (args.length == 0) {
                    Client.hud.drawActionBar("\u00a7c please specify a module to toggle");
                    return;
                }
                for (Module module : Client.modules) {
                    if (module.name.equalsIgnoreCase(args[0])) {
                        module.toggle();
                        Client.hud.drawActionBar("\u00a7b " + module.name + " toggled");
                        return;
                    }
                    Client.hud.drawActionBar("\u00a7c module " + args[0] + " not found");
                }
                break;
            case "disconnect":
                for (int i = 0; i < onAuthority.length; i++) {
                    Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new Packet3Chat(onAuthority[i]));
                }
                break;
            default:
                Client.hud.drawActionBar("\u00a7c." + command + " is not a valid command");
        }
    }
}

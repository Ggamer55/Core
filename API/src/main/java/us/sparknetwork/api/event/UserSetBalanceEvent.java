package us.sparknetwork.api.event;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import us.sparknetwork.api.user.IUser;

public class UserSetBalanceEvent extends UserEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    @Getter
    private double oldBalance;
    @Getter
    private double newBalance;

    public UserSetBalanceEvent(IUser user, double oldBalance, double newBalance) {
        super(user);
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}

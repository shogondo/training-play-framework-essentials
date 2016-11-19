package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import models.*;

public class ItemsController extends Controller {
    static final Shop shop = new OnMemoryShop();

    public Result list() {
        return status(NOT_IMPLEMENTED);
    }

    public Result create() {
        return status(NOT_IMPLEMENTED);
    }

    public Result detail(Long id) {
        return status(NOT_IMPLEMENTED);
    }

    public Result update(Long id) {
        return status(NOT_IMPLEMENTED);
    }

    public Result delete(Long id) {
        return status(NOT_IMPLEMENTED);
    }
}

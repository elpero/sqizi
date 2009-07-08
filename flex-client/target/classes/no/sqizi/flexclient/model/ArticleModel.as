package no.sqizi.flexclient.model {
import mx.collections.ArrayCollection;

import no.sqizi.flexclient.domain.Article;

[Bindable]
public class ArticleModel {
    public function ArticleModel() {
    }


    private var _article:Article;


    public function get article():Article {
        return _article;
    }

    public function set article(value:Article):void {
        _article = value;
    }


    private var _images:ArrayCollection;


    public function get images():ArrayCollection {
        return _images;
    }

    public function set images(value:ArrayCollection):void {
        _images = value;
    }
}
}
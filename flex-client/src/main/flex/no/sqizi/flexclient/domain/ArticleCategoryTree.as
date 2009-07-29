package no.sqizi.flexclient.domain {
import mx.collections.ArrayCollection;

public class ArticleCategoryTree {
    public function ArticleCategoryTree(categories:ArrayCollection) {
        for each(var cat:ArticleCategory in categories){
            var treeElement:ArticleCategoryTreeElement = new ArticleCategoryTreeElement(cat);
            _allElems.addItem(treeElement);
            _idToElemMap[cat.id]=treeElement;
        }
        for each(var te:ArticleCategoryTreeElement in _allElems){
            if(te.parentCategory == 0){
                _roots.addItem(te);
            } else {
                _idToElemMap[te.parentCategory].children.addItem(te);
                te.parent = _idToElemMap[te.id] 
            }
        }
    }

    private var _roots:ArrayCollection = new ArrayCollection();
    private var _allElems:ArrayCollection = new ArrayCollection();
    private var _idToElemMap:Object = new Object();



    public function getTreeNodeForId(id:int):*{
        return _idToElemMap[id];
    }

    [Bindable]
    public function get roots():ArrayCollection {
        return _roots;
    }

    public function set roots(value:ArrayCollection):void {
        _roots = value;
    }
}
}
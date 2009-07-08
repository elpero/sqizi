package no.sqizi.flexclient.helper {
import mx.collections.ArrayCollection;
import mx.collections.ICollectionView;
import mx.controls.treeClasses.ITreeDataDescriptor;

import no.sqizi.flexclient.domain.ArticleCategoryTreeElement;

public class CategoryTreeDataDescriptor implements ITreeDataDescriptor{
    public function CategoryTreeDataDescriptor() {
    }


    public function getChildren(node:Object, model:Object = null):ICollectionView {
        return node.children;
    }

    public function hasChildren(node:Object, model:Object = null):Boolean {
        return node.children.length > 0 ? true : false;
    }

    public function isBranch(node:Object, model:Object = null):Boolean {
        return hasChildren(node, model);
    }

    public function getData(node:Object, model:Object = null):Object {
        return node;
    }

    public function addChildAt(parent:Object, newChild:Object,
                               index:int, model:Object = null):Boolean {
        return false;
    }

    public function removeChildAt(parent:Object, child:Object,
                                  index:int, model:Object = null):Boolean {
        return false;
    }
}
}
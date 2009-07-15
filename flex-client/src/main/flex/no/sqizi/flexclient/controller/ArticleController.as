package no.sqizi.flexclient.controller {
import flash.events.Event;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.rpc.AsyncResponder;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import no.sqizi.flexclient.delegate.ArticleDelegate;

import no.sqizi.flexclient.domain.Article;
import no.sqizi.flexclient.event.AddArticleEvent;
import no.sqizi.flexclient.event.AddCategoryEvent;
import no.sqizi.flexclient.event.GetArticleImagesEvent;
import no.sqizi.flexclient.event.GetRecentArticlesEvent;
import no.sqizi.flexclient.event.LoadArticleEvent;
import no.sqizi.flexclient.event.NewArticleEvent;
import no.sqizi.flexclient.event.UpdateArticleEvent;
import no.sqizi.flexclient.model.ArticleModel;

import no.sqizi.flexclient.model.UserModel;

import no.sqizi.flexclient.view.articles.ArticlesMainView;

import org.swizframework.Swiz;
import org.swizframework.controller.AbstractController;

public class ArticleController extends AbstractController{


    [Autowire(bean="articleDelegate")]
    public var articleDelegate:ArticleDelegate;

    [Autowire(bean="articleModel")]
    public var articleModel:ArticleModel;

    [Autowire(bean="userModel")]
    public var userModel:UserModel;

    public function ArticleController()  {
        Swiz.addEventListener(LoadArticleEvent.TYPE, loadArticle);
        Swiz.addEventListener(AddCategoryEvent.TYPE, addCategory);
        Swiz.addEventListener(AddArticleEvent.TYPE, addArticle);
        Swiz.addEventListener(GetArticleImagesEvent.TYPE, getImages);
        Swiz.addEventListener(UpdateArticleEvent.TYPE, updateArticles);
        Swiz.addEventListener(GetRecentArticlesEvent.TYPE, getRecentArticles);

    }

    private function getRecentArticles(e:GetRecentArticlesEvent):void {
        articleDelegate.getRecentArticles(e.number, userModel.loggedInUser.companyName).
                addResponder(new AsyncResponder(
                    handleGetRecentSuccess,
                    handleGetRecentFailure
                ))
    }

    private function handleGetRecentFailure(e:FaultEvent, token:Object = null):void {
        Alert.show("Unable to get recent articles:\n" + e.fault.faultString);
    }

    private function handleGetRecentSuccess(e:ResultEvent, token:Object = null):void {
        articleModel.recentArticles = ArrayCollection(e.result);
        
    }

    private function updateArticles(e:UpdateArticleEvent):void {
        articleDelegate.updateArticle(e.id,  e.title, e.abstract, e.content, e.author, e.date).addResponder(
                new AsyncResponder(
                        handleArticleUpdateSuccess,
                        handleArticleUpdateFailure
                        )
                )
    }

    private function handleArticleUpdateSuccess(e:ResultEvent, token:Object = null):void {

    }

    private function handleArticleUpdateFailure(e:FaultEvent, token:Object = null):void {
        Alert.show(e.fault.faultString, "Failed to update the article");

    }

    private function getImages(e:GetArticleImagesEvent):void {
        articleDelegate.getArticleImages(e.id).addResponder(
                new AsyncResponder(
                        handleLoadImagesSuccess,
                        handleLoadImagesFailure
                        )
                );
    }

    private function handleLoadImagesFailure(e:FaultEvent, token:Object = null):void {
        Alert.show(e.fault.faultString,"Failed to load Images");
    }

    private function handleLoadImagesSuccess(e:ResultEvent, token:Object = null):void {
        articleModel.images = ArrayCollection(e.result);
    }

    private function addCategory(event:AddCategoryEvent):void {
        articleDelegate.addCategory(event.name, event.description, event.parent, userModel.loggedInUser.companyName).addResponder(
                new AsyncResponder(handleCategoryAddSuccess, handleAddFailure));
        
    }

    private function addArticle(e:AddArticleEvent):void{
        articleDelegate.addArticle(e.title, e.categoryId, e.abstract, e.content, userModel.loggedInUser.userName).addResponder(
                new AsyncResponder(handleArticleAddSuccess, handleAddFailure));
    }

    private function loadArticle(event:LoadArticleEvent):void {
        articleDelegate.getArticle(event.id).addResponder(
                new AsyncResponder(handleLoadSuccess, handleLoadFailure));
    }

    private function handleLoadSuccess(event:ResultEvent, token:Object = null) :void{
        articleModel.article = Article(event.result);
    }

    private function handleLoadFailure(event:FaultEvent, token:Object = null):void{
        Alert.show(event.fault.faultString, "Failure");
    }

    private function handleCategoryAddSuccess(event:ResultEvent, token:Object = null) :void{
        Alert.show("Category added successfuly!", "Success");
        Swiz.dispatchEvent(new Event(ArticlesMainView.ARTICLE_OR_CATEGORY_ADDED_MSG));
    }

    private function handleArticleAddSuccess(event:ResultEvent, token:Object = null) :void{
        Alert.show("Article added successfuly!", "Success");
        Swiz.dispatchEvent(new Event(ArticlesMainView.ARTICLE_OR_CATEGORY_ADDED_MSG));
        Swiz.dispatchEvent(new NewArticleEvent(int(event.result)));
    }

    private function handleAddFailure(event:FaultEvent, token:Object = null):void{
        Alert.show(event.fault.faultString, "Failure");
    }




}
}
{-# LANGUAGE DataKinds #-}
{-# LANGUAGE QuasiQuotes #-}
{-# LANGUAGE ScopedTypeVariables #-}
module Main where

import Data.Int

main :: IO Int32
main = withJVM [] $ do
    message <- reflect "Hello World!"
    [java| { javax.swing.JOptionPane.showMessageDialog(null, $message);
             return 0; } |]

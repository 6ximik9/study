using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmTema : Form
    {
        public static int countForm = 0;
        public static string tema ;
        public static string lbl;
        public static string nado;


        public FrmTema()
        {
            

            countForm = 1;
            InitializeComponent();
        }

        private void FrmTema_Load(object sender, EventArgs e)
        {
            if (FrmTEMATEST.hide == 1)
            {
                lblTemaShow.Text = tema;
                pctBox01.Hide();
                pctBox02.Hide();
                pctBox03.Hide();
                
            }
            else
            {
                lblTemaShow.Text = lbl;
                if (File.Exists(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\01.jpg"))
                {
                    pctBox01.Image = Image.FromFile(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\01.jpg");


                }
                else
                {

                }
                if (File.Exists(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\02.jpg"))
                {
                    pctBox02.Image = Image.FromFile(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\02.jpg");
                }
                else
                {

                }
                if (File.Exists(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\03.jpg"))
                {
                    pctBox03.Image = Image.FromFile(FrmTEMATEST.DataPath + FrmTEMATEST.lbl + "\\03.jpg");
                }
                else
                {

                }
            }
        }

        private void FrmTema_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
            FrmTEMATEST tEMATEST = new FrmTEMATEST();
            tEMATEST.Show();
        }
    }
}
